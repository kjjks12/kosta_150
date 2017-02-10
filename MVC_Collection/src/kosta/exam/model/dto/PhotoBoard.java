package kosta.exam.model.dto;
/**
 * �����Խù� ���� �����
 */
public class PhotoBoard extends Board {

	private String imgName;

	/** Photo Board �⺻������*/
	public PhotoBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	/** Photo Board ������(�۹�ȣ,����,�۾���,��¥)+(�̹��� �̸�)*/
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
		return super.toString()+", �̹��� �̸�: " + imgName ;
	}
	
	
	
	
	
	
	
}
