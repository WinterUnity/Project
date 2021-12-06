
public class DienLanh extends SanPham {
	public DienLanh(String msp, String tensp, int soluong, int gia) {
		super(msp, tensp, soluong, gia);
	}

	@Override
	float tinhtien() {
		double thanhtien = getSoluong() * getGia();
		return (float) thanhtien;
	}

}