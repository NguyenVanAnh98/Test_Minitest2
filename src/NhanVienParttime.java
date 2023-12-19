public class NhanVienParttime extends NhanVien {
    private int soGioLamViec;

    public NhanVienParttime(String maNhanVien, String tenNhanVien, int tuoi, String soDienThoai, String email,
                            int soGioLamViec) {
        super(maNhanVien, tenNhanVien, tuoi, soDienThoai, email);
        this.soGioLamViec = soGioLamViec;
    }

    @Override
    public double tinhLuong() {
        return soGioLamViec * 100000;
    }
}