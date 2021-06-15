package algorithmTwo;

import java.util.*;

/**
 * @description: 1268. 搜索推荐系统
 * @Author: yuzhengshu
 * @Date: 2021年6月15日 11:48
 */
public class Solution6 {
    //30ms
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>(searchWord.length());
        List<String> arrayList = new ArrayList<>(Arrays.asList(products));
        PriorityQueue<String> queue = new PriorityQueue<>(String::compareTo);
        for (int i = 0; i < searchWord.length(); i++) {
            String substring = searchWord.substring(0, i + 1);
            Iterator<String> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                String product = iterator.next();
                if (product.startsWith(substring)) {
                    queue.add(product);
                } else {
                    iterator.remove();
                }
            }
            List<String> tempList = new ArrayList<>(3);
            for (int i1 = 0; i1 < 3 && !queue.isEmpty(); i1++) {
                tempList.add(queue.poll());
            }
            res.add(tempList);
            queue.clear();
        }
        return res;
    }

    //18 - 24ms
    public static List<List<String>> suggestedProducts1(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>(searchWord.length());
        List<String> arrayList = new ArrayList<>(Arrays.asList(products));
        arrayList.sort(String::compareTo);
        for (int i = 0; i < searchWord.length(); i++) {
            Iterator<String> iterator = arrayList.iterator();
            List<String> tempList = new ArrayList<>(3);
            while (iterator.hasNext()) {
                String product = iterator.next();
                if (product.length() > i && product.charAt(i) == searchWord.charAt(i)) {
                    if (tempList.size() < 3) {
                        tempList.add(product);
                    }
                } else {
                    iterator.remove();
                }
            }
            res.add(tempList);
        }
        return res;
    }

    public static void main(String[] args) {
        String word = "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywrywcjmtvaleckwduejlayguredkubbcqhtiafhcsmlgdmpcdouxdyxykmujehtpkjqfbrbyehjcnymgumqwbfouubonhzhvssjmpudpvjtdlurkbwyahtclafjaztcdxstgpsvhbbyndqhfkyycxnrvitcasubhnaeolgmmmedgzqtpjjhtlkwqcnjgwehbriwiklwniobbzhegbisgwccvstmdqyneolakaakrnzhmczxdoxhelbezsggbrzlzrrecyvzvrteofqopamraasigegtovcspphlpmsxsfkouohlwdvgrttzltyojunyvmlmhjjihubmkkbrvsbbdiejimobknxcwntoaqltofqopslhzobiuqhlxivctogflejhdlulda";
        String[] strs = {"ilpxatcgvfbmfunpljkodnbfaowi", "ilpsokmmniywxgbeqrpsaqeqn", "talrnwemajlqicbkxjyf", "sbqhbuvkvntmsutdpyavojqwinxofhvhecbtjjkwdkaazftxvgvicgio", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiameutvrtqwucjp", "l", "ilpxywtmdnlil", "rnjutrkyojwumoyrgzx", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiyrhxnvfqsuymujmvkwctobnuvrusbqt", "ilpxatcgvfblxfvbnoxgmmpvqqvxqyuecwpbjtlzwmmcwspztjjxevjpxdnzcectypljpkjoilnvur", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdkwrfizkvef", "ffngjbmfkxtstjbzalnutfiybfy", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaipwtaovnfhuzu", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuamwsmzfbbtgnfsbujeotpndobpdg", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbl", "ilpxatcfeexjqxghbengdcvsljajqaxidzitqjfjpovxmijvofntfelqidcbekzecqodiralswkjqckrpz", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrklmagbqeadtwhndgodzgfejjcs", "hp", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxovkmfvxdiuceqbvczetytkfvcfykt", "ktihatqubvuvnszewdlcyfqclgwhwsrawtcpdvxwhmvaftzkrvu", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexgkoeppszhfbajvcxuaplxeobzyqe", "ilpxatcgvfblxfvbnoxgmmpvdxthphkvtcfhpevifbuzgcmxqjvtukbgeppeaufwgjbdfppxwszavitpctqthp", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqzxnhaplrwcgwjkr", "ilpxatcgvfkvqfnblpdvtesdandbeynurlcjwwrellxigbsfjccihrvfbsbtcscblctnzededcajrywkj", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypexgkrbzdzmsbimuycjfk", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirysflyamgemsnjibnfxbke", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetvkcqmhquleujnmi", "edmasudelavobnlbrj", "zgjrwqhoqvmaaasqmggcuahifrwwrfrtpvchkuvncpvugmizhpfiokijxwlssapntpecbdgwteqvfdzwu", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedopz", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwhchcgi", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdtdvk", "lnpadggtvd", "xbnfiostesudukxgghwolzawxqlovbnjweddrqcisujmuhsazvetxrsyqdaidrmfomwmanghqn", "zgmmrzerbzujlgomosxmgihordwpzvbnywczhosikslzlaqfyqnrjfbqzqwvihzojyzswbdxczknclmuyhdc", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamclkswqd", "gdqdyysurpvmakyesqoeipuvxlhnffgemhvswyvkbgatxuufhbuitjwnvvigwfweiordqdhtnzagjputzale", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnr", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaxcp", "ilpxatcgvfblxfvbnoxgmmkmnlolyewtuuosejmgconmcjep", "ilpxatcgvfblxfvbnoxgmmpvimowocjrj", "ilpxatcgvfblxfvbnoxgmmpvimowoccbsqkdevdkizvlnrl", "wyeisnjhrhossmnpnexjqbkcsorccgawfgifsmwfdqqadgqdgpfoiagyxperbshwzbnoqqyjr", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcmsdqhbizk", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdqlhdjfflb", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxiedjqmul", "tzkwqsmwdhczbqnimbzgguyqvtywcyzkqhnkdtknumpuikfexldysotnndztwootn", "ilpxatcsfwrpusskcsmzunvejmfymcvs", "usoaljtodfybvquycywtnvivvdvbvymivvc", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiobdewutljgvugibawjskriuxeiwishfimbsinzt", "orrcvinutuqbzlaxrfhsbpjoonsjrubyrbbdghhqnwjz", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqncvydjmnouqktixtgjtvkmwciiuso", "jponpctybxuxtnigdqortyqjiobgdaehgybozbtvxalhyubibburfsjukhalynnkvjr", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxofpsbqljapaqco", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaegtshdqrhtimpvnbymwrlmvghl", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxgcyqcrmwlrjlbnqqfuhypqgiurkyapxzrdsnbeifik", "ilpxatcgvfblxfvbnoxgmmiiubtvodpzwgdgoobsbbnlfjldpqydwejvfysrwhmhg", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqp", "dpwgvxdrbzlh", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpufytsqrkyhiehtjkgohchjkmxcx", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiiwstxiirty", "irjbjafrvdcpqanwt", "ilpxatcgvn", "ilpxatcgvfblxfvbnoxuherdhypducgxsuftiappkjfcqvorxizvdlgswfrqveuhlzitltnushzs", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrypwuijbjublekmxhchhnaxbhbgdaqifvdrfvheqiqcswrskd", "ilpxatcgvtqdvgovjgabbmkdicgymudbikvhihpxfmpanjyp", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamiuzrrvibhkwigjgrqfhn", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlym", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqismi", "jtbuygbbtdyasdtcuswpbquuhswfciyndfton", "ilpxxishsvmt", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvfgdtlfrwklzcwqmbmefnxwrtkpak", "ilpxatcgvfblxfvbnoxgmmpvimowoumiglwjrzletaydenogpldiblrwpyjeqjeow", "hlwga", "ilpxatcgvfblxfvbnjyryxxfayspcrqkvyopfzspzmmhhalwjvfhsgybgkzctlqtr", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxofewrprmowynq", "qyuthohyzttitkgfrfybiuuvzzcqbddrbby", "uinnxgnuuptrxhbhplcdklstqbamsxwaeubppeutqlgngtgzycxpcqjabucoi", "ilpxatcgvfblxfvrpbuumlvymcimuothjdhlsgenxxcllwfibvvcavuiuesgdjhsgoxjzechjhwnprmut", "btrvkwzfdovyyycfxwmxhutvldkblvrsmeyktlwnmdmdepjnkrzkmnerxesvycbrpghnf", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycltcndobbsywuhxohkzostnacjyhj", "dijc", "ilpxatcgvfblxfvbnoxgmmpvimowoccdednjkkgwtekjv", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcwqxooniui", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiyuhbnoibkpmygmul", "potullxiksrpnhngusckddvrtylgwztzxmmgvtrlbgwkgbgohsgbljroghmpwrwupszmkv", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoqpodgpsgmlj", "ryfoisftsawa", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqexqy", "fzvfyiqrwbserbdnnymmcaokpasfpijvbwdxnbctzekkgcudayqlnsclgcxkaeslihczwxphyqbdyxthpuprxjb", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpvoltdohcmslq", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdeyozknywbktmyzkm", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqlc", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypsan", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiarrqyflykjdwvnvicearpou", "yfilpbgdkfmphopolcvjbemkpqcqvcxdkkolpwgco", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztckwzvayxyzaqpm", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywb", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaisnakhppbhnofpnuns", "khdyqeswcmriitjysdj", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpnupiwbdseowsrurzjiscnitdqncuyzxvkuiskezqy", "ilpxatcgvfovxvhriwhgpadztzfcdfgnhktkhqhjiueszhzjpmxrzfgccxovsqxo", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnvncgupn", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetabyivtjxivaraiwg", "zvtcdlbjbnlnadytwqwrnbjomdlmmujvwpmazwbjwippucsujioeevltrrdfivkamxgjtrqckuflvpnbsbrhda", "apkqpncsbbiqstfxplizqbpriqywwjiwquzpfyhwyxfcucwcs", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetjoolenqclkstqazwb", "bjvozgbmtqdxyfirqwhebtijcwrebvdkxtxoahqsjtofybvh", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukfuxkg", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycqgxdkpnisqsfzlkmnpstbd", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrwh", "ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkygsrgv"};
        List<List<String>> lists1 = suggestedProducts(strs, word);
        List<List<String>> lists2 = suggestedProducts1(strs, word);
        for (int i = 0; i < lists1.size(); i++) {
            if (!lists1.get(i).equals(lists2.get(i))) {
                System.out.println(i);
                System.out.println(lists1.get(i));
                System.out.println(lists2.get(i));
            }
        }
//        for (List<String> list : lists1) {
//            System.out.println(list);
//        }
        System.out.println("ilpxatcgvfblxfvbnoxgmmpvimowoccdedkaqiexrcvxpuaiypkycxoeirqztcaiamkdetaiukcnwdnxdqkbrlywrywcjmtvaleckwduejlayguredkubbcqhtiafhcsmlgdmpcdouxdyxykmujehtpkjqfbrbyehjcnymgumqwbfouubonhzhvssjmpudpvjtdlurkbwyahtclafjaztcdxstgpsvhbbyndqhfkyycxnrvitcasubhnaeolgmmmedgzqtpjjhtlkwqcnjgwehbriwiklwniobbzhegbisgwccvstmdqyneolakaakrnzhmczxdoxhelbezsggbrzlzrrecyvzvrteofqopamraasigegtovcspphlpmsxsfkouohlwdvgrttzltyojunyvmlmhjjihubmkkbrvsbbdiejimobknxcwntoaqltofqopslhzobiuqhlxivctogflejhdlulda".charAt(85));

    }
}
