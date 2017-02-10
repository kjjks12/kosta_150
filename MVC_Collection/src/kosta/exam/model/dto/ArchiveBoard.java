package kosta.exam.model.dto;

/** 자료(파일) 정보 저장소 */

public class ArchiveBoard extends Board {

	private String fileName;
	private int fileSize;

	/** ArchiveBoard 디폴트 생성자 */
	public ArchiveBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	/** ArchiveBoard  생성자 
	 *  (글번호,주제,글쓴이,내용,날짜)+ (파일 이름, 파일 크기)
	 * */
	public ArchiveBoard(int no, String subject, String writer, String content, String date, String fileName,
			int fileSize) {
		super(no, subject, writer, content, date);
		this.fileName = fileName;
		this.fileSize = fileSize;
	}
	
	/**Geeter Setter*/
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	@Override
	public String toString() {
		return super.toString()+", 첨부파일 이름 :" + fileName + ", 파일용량 :" + fileSize + "]";
	}
	
	
	
	

}
