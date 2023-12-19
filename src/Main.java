import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<NhanVien> danhSachNhanVien;

    public Main() {
        danhSachNhanVien = new ArrayList<>();
    }

    public void themNhanVien(NhanVien nhanVien) {
        danhSachNhanVien.add(nhanVien);
    }

    public int demSoLuongNhanVien() {
        return danhSachNhanVien.size();
    }

    public double tinhLuongNhanVien(String maNhanVien) {
        double luong = 0;
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMaNhanVien().equals(maNhanVien)) {
                luong = nhanVien.tinhLuong();
                break;
            }
        }
        return luong;
    }

    public double tinhLuongTrungBinhCongTy() {
        double tongLuong = 0;
        for (NhanVien nhanVien : danhSachNhanVien) {
            tongLuong += nhanVien.tinhLuong();
        }
        return tongLuong / danhSachNhanVien.size();
    }

    public double tinhLuongTrungBinhFulltime() {
        double tongLuongFulltime = 0;
        int soLuongFulltime = 0;
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien instanceof NhanVienFulltime) {
                tongLuongFulltime += nhanVien.tinhLuong();
                soLuongFulltime++;
            }
        }
        return tongLuongFulltime / soLuongFulltime;
    }

    public double tinhLuongTrungBinhParttime() {
        double tongLuongParttime = 0;
        int soLuongParttime = 0;
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien instanceof NhanVienParttime) {
                tongLuongParttime += nhanVien.tinhLuong();
                soLuongParttime++;
            }
        }
        return tongLuongParttime / soLuongParttime;
    }
    public double tongluongtraParttime(){
        
    }

    public static void main(String[] args) {
        Main quanLyNhanVien = new Main();

        // Tạo và thêm nhân viên vào danh sách
        NhanVienFulltime nhanVienFulltime1 = new NhanVienFulltime("FT001", "Nguyen Van A", 30, "0123456789", "a@example.com", 5000000, 1000000, 500000);
        quanLyNhanVien.themNhanVien(nhanVienFulltime1);

        NhanVienFulltime nhanVienFulltime2 = new NhanVienFulltime("FT002", "Nguyen Thi B", 28, "0987654321", "b@example.com", 4500000, 800000, 300000);
        quanLyNhanVien.themNhanVien(nhanVienFulltime2);

        NhanVienParttime nhanVienParttime1 = new NhanVienParttime("PT001", "Tran Van C", 25, "0369876542", "c@example.com", 80);
        quanLyNhanVien.themNhanVien(nhanVienParttime1);

        NhanVienParttime nhanVienParttime2 = new NhanVienParttime("PT002", "Tran Thi D", 24, "0987654321", "d@example.com", 60);
        quanLyNhanVien.themNhanVien(nhanVienParttime2);

        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 7) {
            System.out.println("----- MENU -----");
            System.out.println("1. Tính trung bình lương của nhân viên cả công ty.");
            System.out.println("2. Tính trung bình lương của nhân viên fulltime.");
            System.out.println("3. Tính trung bình lương của nhân viên parttime.");
            System.out.println("4. Tính tổng lương phải trả cho nhân viên parttime.");
            System.out.println("5. Đếm số người có mức lương cao hơn mức lương trung bình toàn công ty");
            System.out.println("6. Đếm số nhân viên partime có tên được nhập vào từ bàn phím");
            System.out.println("7. Thoát.");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double luongTrungBinhCongTy = quanLyNhanVien.tinhLuongTrungBinhCongTy();
                    System.out.println("Lương trung bình của nhân viên cả công ty là: " + luongTrungBinhCongTy);
                    break;
                case 2:
                    double luongTrungBinhFulltime = quanLyNhanVien.tinhLuongTrungBinhFulltime();
                    System.out.println("Lương trung bình của nhân viên fulltime là: " + luongTrungBinhFulltime);
                    break;
                case 3:
                    double luongTrungBinhParttime = quanLyNhanVien.tinhLuongTrungBinhParttime();
                    System.out.println("Lương trung bình của nhân viên parttime là: " + luongTrungBinhParttime);
                    break;
                case 4:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        }
        scanner.close();
    }
}