package expensesTracked;

public class ListItem {
    private String header;
    private String desc;
    private String amount;
    public ListItem(String header, String desc, String amount){
        this.header = header;
        this.desc = desc;
        this.amount = amount;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
