package DTO;

import java.util.ArrayList;
import java.util.Objects;

public class ProvinceDTO {
	private int ID;
	private String name;
	
	public ProvinceDTO(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Province [ID=" + ID + ", Name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProvinceDTO other = (ProvinceDTO) obj;
		return ID == other.ID && Objects.equals(name, other.name);
	}
	
	public static ArrayList<ProvinceDTO> getListProvince()
	{
		String[] arr_Province = {"Hà Nội",
				"Vĩnh Phúc",
				"Bắc Ninh",
				"Quảng Ninh",
				"Hải Dương",
				"Hải Phòng",
				"Hưng Yên",
				"Thái Bình",
				"Hà Nam",
				"Nam Định",
				"Ninh Bình",
				"Hà Giang",
				"Cao Bằng",
				"Bắc Kạn",
				"Tuyên Quang",
				"Lào Cai",
				"Yên Bái",
				"Thái Nguyên",
				"Lạng Sơn",
				"Bắc Giang",
				"Phú Thọ",
				"Điện Biên",
				"Lai Châu",
				"Sơn La",
				"Hoà Bình",
				"Thanh Hoá",
				"Nghệ An",
				"Hà Tĩnh",
				"Quảng Bình",
				"Quảng Trị",
				"Thừa Thiên Huế",
				"Đà Nẵng",
				"Quảng Nam",
				"Quảng Ngãi",
				"Bình Định",
				"Phú Yên",
				"Khánh Hoà",
				"Ninh Thuận",
				"Bình Thuận",
				"Kon Tum",
				"Gia Lai",
				"Đắk Lắk",
				"Đắk Nông",
				"Lâm Đồng",
				"Bình Phước",
				"Tây Ninh",
				"Bình Dương",
				"Đồng Nai",
				"Bà Rịa - Vũng Tàu",
				"TP.Hồ Chí Minh",
				"Long An",
				"Tiền Giang",
				"Bến Tre",
				"Trà Vinh",
				"Vĩnh Long",
				"Đồng Tháp",
				"An Giang",
				"Kiên Giang",
				"Cần Thơ",
				"Hậu Giang",
				"Sóc Trăng",
				"Bạc Liêu",
				"Cà Mau"
};
		int i=0;
		ArrayList<ProvinceDTO> listProvince = new ArrayList<>();
		for (String province:arr_Province)
		{
			i++;
			ProvinceDTO t = new ProvinceDTO(i, province);
			listProvince.add(t);
		}
		return listProvince;
	}
	
	
}
