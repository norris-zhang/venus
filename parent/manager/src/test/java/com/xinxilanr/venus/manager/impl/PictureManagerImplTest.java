/**
 * 
 */
package com.xinxilanr.venus.manager.impl;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.xinxilanr.venus.common.ImageUtil;
import com.xinxilanr.venus.common.enums.PictureType;
import com.xinxilanr.venus.dao.PictureDao;
import com.xinxilanr.venus.datamodel.BaseEntity;
import com.xinxilanr.venus.datamodel.Picture;
import com.xinxilanr.venus.datamodel.Post;
import com.xinxilanr.venus.datamodel.User;
import com.xinxilanr.venus.manager.dto.PictureDto;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

/**
 * @author norris
 *
 */
@RunWith(JMockit.class)
public class PictureManagerImplTest {
	private static PictureDao pictureDao = new PictureDaoMockup();
	private static PictureManagerImpl pictureManager;
	private static Path tempDir;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tempDir = Paths.get(System.getProperty("user.home"), UUID.randomUUID().toString());
		if (!tempDir.toFile().exists()) {
			tempDir.toFile().mkdirs();
		}
		pictureManager = new PictureManagerImpl(pictureDao, tempDir.toString());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Files.walk(tempDir, FileVisitOption.FOLLOW_LINKS)
			 .sorted(Comparator.reverseOrder())
			 .map(Path::toFile)
			 .forEach(File::delete);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.xinxilanr.venus.manager.impl.PictureManagerImpl#save(com.xinxilanr.venus.manager.dto.PictureDto)}.
	 * @throws IOException 
	 */
	@Test
	public void saveAPictureShouldInsertToDBAndSavePictureToFile(@Mocked ImageUtil imageUtil) throws IOException {
		((PictureDaoMockup)pictureDao).setPictureId(1L);
		PictureDto dto = new PictureDto();
		dto.setData(new byte[]{'1'})
		   .setOriginalFileExt("jpg")
		   .setOriginalFileName("abc")
		   .setPictureType(PictureType.fromExtension("jpg"));
		
		pictureManager.save(dto);
		
		new Verifications() {{pictureDao.insert(withAny(new Picture()));}};
		assertThat(tempDir.resolve("0/1.jpg").toFile().exists(), equalTo(true));
	}
	
	private static class PictureDaoMockup extends MockUp<PictureDao> implements PictureDao {
		private long pictureId;
		@Mock
		public void insert(BaseEntity entity) {
			((Picture)entity).setId(pictureId);
		}

		@Override
		public int delete(BaseEntity c) {
			return 0;
		}

		@Override
		public BaseEntity get(Class<? extends BaseEntity> clazz, Serializable id) {
			if (User.class.equals(clazz)) {
				return new User().setId(1L);
			} else if (Post.class.equals(clazz)) {
				return null;
			}
			return null;
		}

		@Override
		public void update(BaseEntity entity) {
			
		}
		public void setPictureId(long pictureId) {
			this.pictureId = pictureId;
		}
		
	}
}
