package phuongHoaAn;

public class TPBank {
    //PHạm vi ngoài CLass nhưng trong cùng 1 package

    public void showTVName(){
        FPTCorporation fpt = new FPTCorporation();

        fpt.tvName = "TPBank LCD";
        fpt.setTvName();

        fpt.tvColor = "Blue";
        fpt.setTvColor();

        fpt.tvChannel ="";
        fpt.setTvChannel();

    }
}
