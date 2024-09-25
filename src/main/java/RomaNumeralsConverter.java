import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转阿拉伯数字
 * 罗马数字采用七个基本符号：‌I(1)、‌X(10)、‌C(100)、‌M(1000)、‌V(5)、‌L(50)、‌D(500)。记数时不用位值制而用加减制，相同的数字连写表示相加，不同数字并列时，小数放在大数的右边作为加数，放在大数的左边作为减数。
 *
 * 罗马数字的具体应用规则
 * ‌相同的数字连写‌：如Ⅲ表示3，ⅩⅩ表示20。连写的数字重复不得超过三次，如40表示为XL。
 * ‌小的数字在大的数字的右边‌：如Ⅷ=8，Ⅻ=12。
 * ‌小的数字在大的数字的左边‌：如Ⅳ=4，Ⅸ=9。但限于Ⅰ、X和C。
 * ‌大过1000的数‌：在符号上方加一条横线表示乘以1000，不常见。
 */
public class RomaNumeralsConverter {

    public static void main(String[] args){
        int result = new RomaNumeralsConverter().toArabicNumerals("III");
        System.out.println("result:"+result);
        result = new RomaNumeralsConverter().toArabicNumerals("VI");
        System.out.println("result:"+result);
        result = new RomaNumeralsConverter().toArabicNumerals("XCVII");
        System.out.println("result:"+result);
        result = new RomaNumeralsConverter().toArabicNumerals("CDLXXIX");
        System.out.println("result:"+result);
    }

    public int toArabicNumerals(String romaNumerals){
        Map<Character,Integer> labelMap = new HashMap<>();
        labelMap.put('I',1);
        labelMap.put('V',5);
        labelMap.put('X',10);
        labelMap.put('L',50);
        labelMap.put('C',100);
        labelMap.put('D',500);
        labelMap.put('M',1000);

        int result = 0;
        int preItem = 0;
        for(int i=0;i< romaNumerals.length();i++){
            char c = romaNumerals.charAt(i);
            int item = labelMap.get(c);
            if(preItem<item){
                preItem = -preItem;
            }
            result += preItem;
            preItem = item;
        }
        result += preItem;
        return result;
    }
}
