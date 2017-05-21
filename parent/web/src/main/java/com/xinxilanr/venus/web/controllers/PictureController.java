/**
 * 
 */
package com.xinxilanr.venus.web.controllers;

import static com.xinxilanr.venus.web.session.SessionUser.SESSION_USER_KEY;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xinxilanr.venus.common.FileUtil;
import com.xinxilanr.venus.common.enums.PictureType;
import com.xinxilanr.venus.common.image.picture.PictureUtil;
import com.xinxilanr.venus.manager.ClusteredSession;
import com.xinxilanr.venus.manager.PictureManager;
import com.xinxilanr.venus.manager.dto.PictureDto;
import com.xinxilanr.venus.web.session.SessionUser;
import com.xinxilanr.venus.web.utils.CookieHandler;
import com.xinxilanr.venus.web.vo.PictureResponse;
import com.xinxilanr.venus.web.vo.PictureResponse.Picture;

/**
 * @author norris
 *
 */
@Controller
@RequestMapping("/picture")
public class PictureController extends BaseController {
	private PictureManager pictureManager;
	private ClusteredSession sessionRepo;
	private String pictureFilePath;
	private String pictureFileUrl;
	@Autowired
	public PictureController(PictureManager pictureManager,
			ClusteredSession sessionRepo,
			@Value("${picture.file.path}") String pictureFilePath,
			@Value("${picture.file.url}") String pictureFileUrl) {
		this.pictureManager = pictureManager;
		this.sessionRepo = sessionRepo;
		this.pictureFilePath = pictureFilePath;
		this.pictureFileUrl = pictureFileUrl;
	}
	@GetMapping("/upload")
	public String upload() {
		return "picture/upload";
	}
	
	/**
	 * https://spring.io/guides/gs/uploading-files/
	 * 
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/upload")
	public @ResponseBody PictureResponse upload(@RequestParam("files[]") MultipartFile[] files,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PictureResponse pictureResponse = new PictureResponse();
		for (MultipartFile file : files) {
			PictureDto pictureDto = pictureManager.save(toPictureDto(file, request, response));
			file.transferTo(getDestFile(pictureDto));
			pictureResponse.addFile(responsePicture(pictureDto));
		}
		return pictureResponse;
	}
	private Picture responsePicture(PictureDto pictureDto) {
		Picture picture = new Picture();
		picture.setName(pictureDto.getOriginalFileName());
		picture.setSize(pictureDto.getData().length);
		picture.setUrl(String.format(pictureFileUrl, pictureDto.getPictureId()));
		picture.setThumbnailUrl(String.format(pictureFileUrl, pictureDto.getPictureId()));
		picture.setDeleteUrl(String.format(pictureFileUrl, pictureDto.getPictureId()));
		return picture;
	}
	private File getDestFile(PictureDto pictureDto) {
		Path path = Paths.get(pictureFilePath);
		path = path.resolve(PictureUtil.getRelativeDirFromPictureId(pictureDto.getPictureId(), PictureType.fromExtension(pictureDto.getOriginalFileExt())));
		File parentDir = path.toFile().getParentFile();
		if (!parentDir.exists()) {
			parentDir.mkdirs();
		}
		return path.toFile();
	}
	private PictureDto toPictureDto(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sessionId = new CookieHandler(request, response).getClusteredSessionId();
		Map<String, Object> session = sessionRepo.getSession(sessionId);
		SessionUser sessionUser = (SessionUser)session.get(SESSION_USER_KEY);
		String fileExtension = FileUtil.getExtensionFromFileName(file.getOriginalFilename());
		PictureDto pictureDto = new PictureDto()
				.setUserId(sessionUser.getUserId())
				.setOriginalFileName(file.getOriginalFilename())
				.setOriginalFileExt(fileExtension)
				.setPictureType(PictureType.fromExtension(fileExtension))
				.setData(file.getBytes());
		return pictureDto;
	}
}
