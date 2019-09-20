package day4.assignment1.action;

import java.io.File;
import javax.activation.MimetypesFileTypeMap;

import com.opensymphony.xwork2.ActionSupport;
import common.util.Constants;
import day4.assignment1.logic.UploadLogic;

/**
 * Upload action class to execute the logic to upload file
 *
 * @author Jyoti
 *
 */
public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public boolean status = false;
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;

	private File saveFilePath;
	UploadLogic objLogic = new UploadLogic();

	// Execution starts from here
	public String execute() {

		// Start
		try {
			if (fileUploadFileName.length() > 0) {

				// change the path according to the use
				saveFilePath = new File(Constants.FILE_UPLOAD + fileUploadFileName);

				File f = new File(saveFilePath.toString());
				double fileSize = f.length() / 1024;

				if (fileSize < 20000) {

					// Checking uploaded file is images type or not
					String mimetype = new MimetypesFileTypeMap().getContentType(f);
					String type = mimetype.split("/")[0];
					if (type.equals("image")) {
						// passing file object and full path
						objLogic.uploadFile(fileUpload, saveFilePath);
						clearActionErrors();
						objLogic.insertToDB(fileUploadFileName, saveFilePath);
						addActionMessage(Constants.FILE_UPLOAD_SUCCESSFULL);
						return SUCCESS;
					} else {
						addActionError(Constants.NOT_IMAGE_FILE);
						return ERROR;
					}
				} else {
					addActionError(Constants.FILE_SIZE_EXCEEDS);
					return ERROR;
				}
			} else {
				addActionError(Constants.SELECT_IMAGE);
				return ERROR;
			}
		} catch (Exception ex) {
			addActionError(Constants.IMAGE_NOT_SELECTED);
			return ERROR;
		}
	}

	// Getter and Setter methods
	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public File getSaveFilePath() {
		return saveFilePath;
	}

	public void setSaveFilePath(File saveFilePath) {
		this.saveFilePath = saveFilePath;
	}

}
