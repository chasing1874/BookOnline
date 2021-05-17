package chasing.pojo;

import java.sql.Date;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-14  7:23 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class Eb {
    private Integer no;
    private Date date;
    private String info;
    private String href;
    private Integer day1;
    private Integer day2;
    private Integer day4;
    private Integer day7;
    private Integer day15;
    private Integer month1;
    private Integer month3;
    private Integer month6;

    public Eb() {
    }

    public Eb(Integer no, Date date, String info, String href, Integer day1, Integer day2, Integer day4, Integer day7, Integer day15, Integer month1, Integer month3, Integer month6) {
        this.no = no;
        this.date = date;
        this.info = info;
        this.href = href;
        this.day1 = day1;
        this.day2 = day2;
        this.day4 = day4;
        this.day7 = day7;
        this.day15 = day15;
        this.month1 = month1;
        this.month3 = month3;
        this.month6 = month6;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getDay1() {
        return day1;
    }

    public void setDay1(Integer day1) {
        this.day1 = day1;
    }

    public Integer getDay2() {
        return day2;
    }

    public void setDay2(Integer day2) {
        this.day2 = day2;
    }

    public Integer getDay4() {
        return day4;
    }

    public void setDay4(Integer day4) {
        this.day4 = day4;
    }

    public Integer getDay7() {
        return day7;
    }

    public void setDay7(Integer day7) {
        this.day7 = day7;
    }

    public Integer getDay15() {
        return day15;
    }

    public void setDay15(Integer day15) {
        this.day15 = day15;
    }

    public Integer getMonth1() {
        return month1;
    }

    public void setMonth1(Integer month1) {
        this.month1 = month1;
    }

    public Integer getMonth3() {
        return month3;
    }

    public void setMonth3(Integer month3) {
        this.month3 = month3;
    }

    public Integer getMonth6() {
        return month6;
    }

    public void setMonth6(Integer month6) {
        this.month6 = month6;
    }

    @Override
    public String toString() {
        return "Eb{" +
                "no=" + no +
                ", date='" + date + '\'' +
                ", info='" + info + '\'' +
                ", href='" + href + '\'' +
                ", day1=" + day1 +
                ", day2=" + day2 +
                ", day4=" + day4 +
                ", day7=" + day7 +
                ", day15=" + day15 +
                ", month1=" + month1 +
                ", month3=" + month3 +
                ", month6=" + month6 +
                '}';
    }
}
