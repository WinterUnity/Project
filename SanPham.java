
public abstract class SanPham {
	protected String msp;
	protected String tensp;
	protected int soluong;
	protected double gia;
	protected String loai;

	abstract float tinhtien();
	
	public SanPham(String msp, String tensp, int soluong, int gia) {
		super();
		this.msp = msp;
		this.tensp = tensp;
		this.soluong = soluong;
		this.gia = gia;
		// this.loai = loai;
	}

	public String getMsp() {return msp;}
	public void setMsp(String msp) {this.msp = msp;}

	public String getTensp() {return tensp;}
	public void setTensp(String tensp) {this.tensp = tensp;}

	public int getSoluong() {return soluong;}
	public void setSoluong(int soluong) {this.soluong = soluong;}

	public double getGia() {return gia;}
	public void setGia(double gia) {this.gia = gia;}
	
//	public String getLoai() {return loai;}
//	public void setLoai(String loai) {this.loai = loai;}

}
