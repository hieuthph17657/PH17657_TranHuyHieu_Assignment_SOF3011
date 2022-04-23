package entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="carts")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int donGia;

 	private int kichThuoc;

	private String mauSac;

	private int soLuong;
	
	private String sdt;
	
	private int tongTien;
	
	private int trangThai;

	private String ten;
	
	private String diaChi;

	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="user_id")
	private int userId;
	
	public Cart() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getDonGia() {
		return this.donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	

	public int getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(int kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public String getMauSac() {
		return this.mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	
	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", donGia=" + donGia + ", kichThuoc=" + kichThuoc + ", mauSac=" + mauSac
				+ ", soLuong=" + soLuong + ", sdt=" + sdt + ", tongTien=" + tongTien + ", trangThai=" + trangThai
				+ ", ten=" + ten + ", diaChi=" + diaChi + ", categoryId=" + categoryId + ", userId=" + userId + "]";
	}

	

	
}