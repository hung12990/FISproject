package vn.fis.training.domain;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

public class Customer {
    /** ID cua Customer la duy nhat trong toan bo he thong
       Su dung @java.util.UUID de tao id gan cho tung customer
    */
    private String id=UUID.randomUUID().toString();

    /** Constraints:
        1. Khong duoc trong (NOT NULL OR BLANK)
        2. Do dai tu tu 5 den 50 ky tu, chi bao gom ky tu a->z, A->Z va khong trang (Blank).
        3. Truoc khi cap nhat vao he thong truong ten phai duoc chuan hoa.
            Qui tac chuan hoa:
                *. Bo cac ky tu trang o dau va cuoi
                *. Upper case chu cai dau tien truoc cac tu
                   VD: nGuyen van    BinH      -> Nguyen Van Binh
    **/
    private String name;
    /** Constraints:
        1. Khong duoc trong
        2. Tinh toan de khong cho phep nhap Customer nho hon 10 tuoi so voi thoi diem hien tai
     **/
    private LocalDate birthDay;
    /** Constraints:
    *   1. Do dai 10 ky tu bat dau bang ky tu 0, chi bao gom cac so tu 0->9
     *  2. So dien thoai la duy nhat trong toan bo he thong. Duoc su dung de kiem tra duplicate khach hang
     *  3. Chuan hoa lai truong so dien thoai truoc khi cap nhat vao he thong. Bo cac ky tu trang o dau, giua va cuoi
     *     Vidu: 0921 000 008 --> 0921000008
    * */
    private String mobile;

    /** Constraints:
     * NOT NULL
     * */

    private CustomerStatus status;

    /**
     * Thoi gian tao doi tuong. mac dinh la thoi diem hien tai
     */

    private LocalDateTime createDateTime=java.time.LocalDateTime.now();

    // TODO: Implement Getters, Setters, Constructors, Equals

    public Customer(String id, String name, LocalDate birthDay, String mobile, CustomerStatus status, LocalDateTime createDateTime) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.mobile = mobile;
        this.status = status;
        this.createDateTime = createDateTime;
    }

    public Customer() {
    }

    public String getId() {

        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) throws IOException {
        /** Constraints:
         1. Khong duoc trong (NOT NULL OR BLANK)
         2. Do dai tu tu 5 den 50 ky tu, chi bao gom ky tu a->z, A->Z va khong trang (Blank).
         3. Truoc khi cap nhat vao he thong truong ten phai duoc chuan hoa.
         Qui tac chuan hoa:
         *. Bo cac ky tu trang o dau va cuoi
         *. Upper case chu cai dau tien truoc cac tu
         VD: nGuyen van    BinH      -> Nguyen Van Binh
         **/

 if(name==null || name.isEmpty())  throw new IOException("name NOT NULL OR BLANK");

if(name.length()<5 || name.length()>50) throw new IOException("name Do dai tu tu 5 den 50 ky tu");
if(Pattern.matches("^[a-zA-Z]", name)) throw new IOException("name chi bao gom ky tu a->z, A->Z");
//        Qui tac chuan hoa:
//         *. Bo cac ky tu trang o dau va cuoi
//                *. Upper case chu cai dau tien truoc cac tu
        name=name.trim();
        String[] tokens = name.split("\\s");
        name = "";

        for(int i = 0; i < tokens.length; i++){
            char capLetter = Character.toUpperCase(tokens[i].charAt(0));
            name +=  " " + capLetter + tokens[i].substring(1);
        }

        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) throws IOException {
        /** Constraints:
         1. Khong duoc trong
         2. Tinh toan de khong cho phep nhap Customer nho hon 10 tuoi so voi thoi diem hien tai
         **/
        Date date = java.sql.Date.valueOf(birthDay);
try {
    if(birthDay.toString().isEmpty())  throw new IOException("birthDay NOT BLANK");

    if (Period.between(birthDay, java.time.LocalDate.now()).getYears()<10) throw new IOException("birthDay NOT BLANK");




    this.birthDay = birthDay;
}catch (Exception e){
    throw new IOException("name NOT BLANK");

}

        this.birthDay = birthDay;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) throws IOException {

        try {
            if(birthDay.toString().isEmpty())  throw new IOException("status NOT BLANK");

            this.status = status;
            this.birthDay = birthDay;
        }catch (Exception e){
            throw new IOException("status NOT BLANK");

        }

    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
