package kosta.exam.model.dto;
/**
 * 사진게시물 정보 저장소
 */
public class PhotoBoard extends Board {

	private String imgName;

	/** Photo Board 기본생성자*/
	public PhotoBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	/** Photo Board 생성자(글번호,주제,글쓴이,날짜)+(이미지 이름)*/
	public PhotoBoard(int no, String subject, String writer, String content, String date, String imgName) {
		super(no, subject, writer, content, date);
		this.imgName = imgName;
	}
	
	
	
	/**Getter Setter*/
	public String getImgName() {
		return imgName;
	}
	
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	@Override
	public String toString() {
		return super.toString()+", 이미지 이름: " + imgName ;
	}
	
	
	
	
	
	
	
}
