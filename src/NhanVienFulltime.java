public class NhanVienFulltime extends NhanVien {
    private double luongCung;
    private double soTienThuong;
    private double soTienPhat;

    public NhanVienFulltime(String maNhanVien, String tenNhanVien, int tuoi, String soDienThoai, String email,
                            double luongCung, double soTienThuong, double soTienPhat) {
        super(maNhanVien, tenNhanVien, tuoi, soDienThoai, email);
        this.luongCung = luongCung;
        this.soTienThuong = soTienThuong;
        this.soTienPhat = soTienPhat;
    }

    @Override
    public double tinhLuong() {
        return luongCung + (soTienThuong - soTienPhat);
    }
}