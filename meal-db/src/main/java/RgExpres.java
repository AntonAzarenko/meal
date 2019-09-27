import java.util.regex.Pattern;

public class RgExpres {

    private  String  reg = "B-[0-9]+ (AT )*(FDA|LM|CDP|SC|Common): [a-zA-Z #;-\\_()0-9]+: .*[a-zA-Z0-9+]$|Revving up build version$|(CDP|RDSC)-[0-9]+ .*$|B-[0-9]+ Tech Debt: (AT )*(FDA|LM|CDP|SC|Common): .*[a-zA-Z0-9+]$|B-[0-9]+ (AT )*(FDA|LM|CDP|SC|Common): [a-zA-Z #;-]+: make changes based on comments in CR-[A-Z-]{1,}[0-9]{1,}$";
    Pattern pattern = Pattern.compile(reg);
}
