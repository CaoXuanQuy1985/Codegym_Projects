package app;

public class DateMonth {
    private short month;

    public DateMonth(short month){
        this.month = month;
    }

    public short getMonth(){
        return this.month;
    }

    public void deterDate(){
        if((this.month <= 1) || (this.month >= 12)){
            System.out.println("This month is invalid, try another month !!!");
        }else{
            switch(this.month){
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println("Tháng " + this.month + " có 30 ngày");
                    break;
                case 2:
                    System.out.println("Tháng 2 có thể có 28 hoặc 29 ngày");
                    break;
                default:
                    System.out.println("Tháng " + this.month + " có 31 ngày");
                    break;
            }
        }
    }

    public static void main(String[] args){
        DateMonth month1 = new DateMonth((short)5),
                        month2 = new DateMonth((short)10),
                        month3 = new DateMonth((short)123);

        month1.deterDate();
        month2.deterDate();
        month3.deterDate();
    }
}