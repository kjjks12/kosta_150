package memo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CustomFile {

	BufferedReader br = null;
	BufferedWriter bw = null;

	String path;

	private Memo memo = null;

	public CustomFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomFile(Memo memo) {
		this.memo = memo;
		// 필터 셋팅
	}

	public void fileLoad() {
		try {
			memo.chooser.showOpenDialog(null);
			path= memo.chooser.getSelectedFile().getPath();
			br = new BufferedReader(new FileReader(path));
			String str;
			while ((str = br.readLine()) != null) {
				memo.textArea.append(str + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				
			}
		}
	}

	public void fileSave() {
		try {
			memo.chooser.showSaveDialog(null);
			path= memo.chooser.getSelectedFile().getPath();
			System.out.println("경로 ="+ path );
			bw = new BufferedWriter(new FileWriter(path));
			//System.out.println(memo.textArea.getText());
			bw.write(memo.textArea.getText());

		} catch (IOException e) {
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
			}
		}

	}

}