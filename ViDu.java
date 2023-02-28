import java.io.File;
import java.util.Scanner;

public class ViDu {
	File file;

	public ViDu(String tenFile) {
		
		this.file = new File(tenFile);
		
	}
	public boolean kiemTraThucThi() {
		return this.file.canExecute();
	}
	public boolean kiemTraDoc() {
		return this.file.canRead();
	}
	public boolean kiemTraGhi() {
		return this.file.canWrite();
	}
	public String inDuongDan() {
		return this.file.getAbsolutePath();
	}
	public String inTenFile() {
		return this.file.getName();
	}
	public void kiemTraFile() {
		if(this.file.isDirectory()) {
			System.out.println("Kiểm tra file là thư mục ");
		}else if(this.file.isFile()){
			System.out.println("Kiểm tra file là tập tin");
		}
	}
	
	public void danhSachFileCon() {
		if(this.file.isDirectory()) {
			System.out.println("Các tập tin con bên trong  ");
			File[] fileCon = this.file.listFiles();
			for (File file : fileCon) {
				System.out.println(file.getAbsolutePath());
			}
		}else if(this.file.isFile()) {
			System.out.println("Không có dữ liệu bên trong ");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luaChon = 0;
		System.out.println("Nhap ten file: ");
		String tenFile = sc.nextLine();
		ViDu vdFile = new ViDu(tenFile);
		
		do {
			System.out.println("-------Menu---------");
			System.out.println("1. Kiểm tra file có thể thực thi:");
			System.out.println("2. Kiểm tra file có thể đọc: ");
			System.out.println("3. Kiểm tra file có thể ghi:");
			System.out.println("4. In đường dẫn:");
			System.out.println("5. In tên file:");
			System.out.println("6. Kiểm tra file là thư mục hay tập tin: ");
			System.out.println("7. In ra danh sách các file con: ");
			System.out.println("0. Thoát chương trình");
			
			System.out.println("Nhập lựa chọn : ");
			luaChon = sc.nextInt();
			sc.nextLine();
			
			switch (luaChon) {
			case 1:
				System.out.println("File có thể thực thi:"+ vdFile.kiemTraThucThi());
				break;
			case 2:				
				System.out.println("Kiểm tra file có thể đọc:"+ vdFile.kiemTraDoc());				
				break;
			case 3:
				System.out.println("Kiểm tra file có thể ghi:"+ vdFile.kiemTraGhi());
				break;
			case 4:
				System.out.println("In đường dẫn:"+ vdFile.inDuongDan());
				break;
			case 5:
				System.out.println("In tên file: "+ vdFile.inTenFile());
				break;
			case 6:
				vdFile.kiemTraFile();
				break;
			case 7:
				vdFile.danhSachFileCon();
				break;
				
			default:
				break;
			}
		} while (luaChon != 0);
	}
}
