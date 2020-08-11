import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PhoneManager phoneManager = new PhoneManager();

        boolean check = true;
        while (check) {
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1.Xem Danh Sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi từ file");
            System.out.println("8.Thoát");
            System.out.println("Chọn chức năng:");

            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Danh bạ :");
                        phoneManager.show();
                        break;
                    case 2:
                        phoneManager.add();
                        System.out.println("Thêm thành công.");
                        break;
                    case 3:
                        System.out.println("Nhập số ĐT cần sửa:");
                        phoneManager.edit();
                        break;
                    case 4:
                        System.out.println("Nhập số ĐT muốn xóa :");
                        sc.nextLine();
                        String number = sc.nextLine();
                        if (number.equals("")){
                            break;
                        }else {
                            phoneManager.delete(number);
                        }
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.println("Nhập từ khóa tìm kiếm :");
                        String key = sc.nextLine();
                        phoneManager.searchProduct(key);
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 0:
                        check = false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Yêu cầu nhập số");
                Main.sc.nextLine();
            }
        }

    }
}

