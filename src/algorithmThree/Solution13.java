package algorithmThree;

import java.util.Arrays;

/**
 * @description: 1833. 雪糕的最大数量
 * @Author: yuzhengshu
 * @Date: 2021年7月2日 09:49
 */
public class Solution13 {
    public static int maxIceCream(int[] costs, int coins) {
        int[] value = new int[coins+1];
        for (int cost : costs) {
            for (int j = coins; j >= cost; j--) {
                value[j] = Math.max(value[j], value[j - cost] + 1);
            }
        }
        return value[coins];
    }

    public static int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if (coins - cost >= 0) {
                coins = coins - cost;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] costs = {1027, 23, 1133, 326, 1946, 986, 1570, 1385, 1489, 1082, 1557, 1066, 42, 1518, 1318, 605, 746, 1556, 1042, 1782, 452, 1778, 504, 727, 296, 474, 1874, 1452, 2, 1124, 778, 1218, 1142, 1610, 812, 1610, 80, 930, 260, 438, 1732, 1007, 998, 1026, 718, 1262, 1450, 1342, 1115, 914, 1632, 1786, 1893, 1098, 647, 846, 658, 242, 1674, 669, 1551, 453, 858, 840, 1866, 746, 1165, 802, 1210, 82, 1494, 726, 1106, 1778, 502, 1101, 897, 1816, 812, 918, 571, 105, 946, 1822, 1258, 12, 418, 1962, 1961, 751, 902, 1418, 1434, 1012, 1936, 1258, 620, 312, 917, 770, 242, 855, 958, 1466, 434, 1782, 981, 702, 34, 498, 1547, 1546, 1502, 40, 947, 99, 1288, 1656, 194, 1458, 822, 1551, 1338, 1402, 302, 1027, 722, 222, 1194, 482, 1278, 1470, 1459, 1852, 1408, 1754, 206, 1002, 1247, 26, 1650, 294, 1602, 1963, 984, 332, 652, 1066, 1377, 1684, 2, 926, 1088, 1972, 420, 1178, 596, 1469, 578, 1224, 1997, 462, 460, 1000, 1555, 657, 202, 1190, 162, 1217, 2000, 262, 1222, 354, 205, 1092, 719, 1154, 522, 562, 1552, 910, 1370, 312, 886, 469, 1466, 1855, 618, 438, 1447, 752, 826, 1801, 686, 591, 177, 946, 1671, 1992, 1003, 810, 1372, 430, 974, 76, 1632, 258, 730, 1528, 502, 1527, 242, 962, 766, 462, 1712, 51, 978, 650, 318, 1920, 898, 994, 126, 607, 651, 73, 1298, 1118, 1386, 1308, 311, 76, 1919, 1828, 584, 1762, 1238, 1112, 946, 1962, 1970, 567, 1012, 1352, 1017, 1732, 162, 894, 12, 688, 198, 506, 370, 1692, 98, 1784, 1107, 1552, 886, 419, 1410, 162, 599, 1242, 1802, 958, 1027, 1935, 1232, 1250, 1696, 58, 1324, 661, 1342, 465, 444, 1042, 1438, 602, 274, 496, 229, 562, 468, 586, 599, 1586, 557, 517, 55, 122, 1049, 1538, 1896, 1782, 124, 792, 329, 1236, 1858, 535, 731, 22, 792, 322, 1924, 1340, 357, 1206, 1506, 1970, 1360, 512, 284, 67, 102, 1038, 328, 216, 572, 1449, 1242, 1842, 990, 207, 1722, 95, 1440, 256, 1627, 1657, 224, 1727, 1852, 1707, 1666, 1490, 277, 106, 1562, 1022, 90, 847, 114, 1027, 1695, 722, 1312, 336, 992, 962, 1438, 1459, 1082, 426, 1498, 762, 1025, 1687, 1690, 1752, 2000, 658, 500, 942, 436, 67, 1946, 187, 1526, 127, 1812, 910, 602, 1655, 1044, 914, 237, 624, 513, 1232, 1697, 1388, 1440, 954, 1459, 407, 569, 1522, 1544, 1514, 404, 915, 620, 1308, 1614, 610, 1070, 809, 713, 1994, 1402, 874, 1457, 232, 1632, 1228, 1452, 1170, 1010, 558, 1430, 1720, 1378, 730, 326, 1814, 1254, 276, 1009, 787, 1571, 402, 687, 1612, 967, 622, 1782, 1828, 1775, 1266, 626, 398, 784, 90, 528, 992, 1519, 1665, 804, 1917, 1218, 421, 1569, 1738, 1026, 1970, 1498, 190, 1701, 1410, 1839, 1403, 1889, 82, 1924, 255, 298, 412, 1457, 737, 1028, 86, 1967, 1415, 1892, 1803, 1570, 1802, 548, 147, 1178, 1502, 1942, 452, 392, 1904, 370, 376, 1930, 294, 1902, 1634, 90, 1829, 1612, 136, 1846, 1200, 194, 1830, 1886, 1326, 722, 1186, 1752, 559, 284, 389, 442, 1573, 405, 1906, 1050, 1154, 1321, 688, 1152, 242, 1112, 1590, 800, 177, 1394, 982, 794, 1882, 1552, 564, 377, 990, 857, 1702, 1402, 1204, 1370, 1948, 1471, 1217, 499, 382, 774, 1350, 1340, 810, 306, 1213, 1096, 1226, 990, 834, 1882, 1718, 1667, 1058, 202, 936, 1777, 1528, 1162, 1143, 508, 610, 370, 794, 454, 582, 1339, 982, 1116, 1478, 1382, 326, 1098, 1762, 1377, 1930, 14, 1410, 902, 600, 1118, 1372, 128, 628, 588, 1562, 1262, 682, 274, 930, 1116, 582, 913, 611, 38, 450, 317, 418, 362, 1626, 1113, 1454, 71, 1312, 1102, 550, 1538, 1519, 1626, 305, 1182, 764, 770, 716, 1342, 1162, 1874, 252, 1662, 344, 490, 910, 640, 594, 1226, 331, 1920, 165, 1337, 1832, 988, 372, 52, 1304, 127, 118, 620, 492, 1903, 615, 1606, 1578, 1844, 146, 903, 739, 338, 1689, 610, 619, 226, 336, 518, 618, 370, 1012, 602, 438, 846, 1605, 936, 842, 1180, 1654, 978, 2, 542, 690, 1294, 1866, 1122, 52, 1620, 1208, 54, 1554, 46, 456, 177, 1632, 1477, 467, 1626, 1410, 617, 1292, 81, 701, 1490, 1546, 1113, 1258, 147, 644, 767, 1617, 1034, 186, 1250, 661, 611, 579, 1002, 1205, 1638, 922, 1400, 367, 1466, 437, 1481, 1762, 1716, 202, 534, 1517, 1542, 1700, 1502, 436, 2, 1282, 266, 1927, 282, 1738, 1654, 214, 982, 452, 434, 1444, 1003, 436, 1808, 1027, 1154, 518, 1674, 1751, 1632, 532, 627, 102, 130, 1592, 546, 1834, 392, 354, 402, 1022, 1024, 178, 772, 552, 50, 1034, 2, 1949, 486, 1718, 480, 787, 1266, 1407, 24, 590, 752, 1182, 116, 1030, 1394, 1062, 1856, 1130, 732, 408, 740, 249, 212, 1562, 1734, 1880, 1442, 373, 1402, 1194, 503, 1856, 1916, 418, 1152, 906, 937, 914, 1633, 196, 1747, 1962, 1698, 607, 655, 157, 1848, 799, 196, 197, 236, 1337, 298, 402, 398, 1068, 767, 1042, 342, 25, 923, 1786, 574, 1551, 1818, 816, 1416, 1914, 1790, 1951, 1812, 1184, 696, 1658, 532, 485, 1026, 877, 1458, 82, 1442, 1174, 1068, 66, 1867, 809, 992, 370, 696, 1031, 930, 394, 916, 462, 1730, 554, 1952, 926, 712, 1658, 182, 754, 946, 554, 442, 1119, 82, 1104, 1961, 617, 348, 175, 6, 802, 1854, 1582, 194, 1312, 1380, 84, 594, 1079, 866, 650, 1594, 876, 770, 1612, 932, 578, 572, 16, 1102, 13, 277, 898, 1022, 239, 1792, 1970, 915, 332, 252, 947, 1805, 1994, 1273, 1550, 418, 217, 990, 1987, 725, 1720, 570, 801, 982, 33, 227, 1577, 1554, 522, 850, 272, 1216, 894, 54, 1582, 447, 572, 1469, 1450, 206, 1660, 562, 987, 1958, 214, 152, 1492, 778, 152, 1120, 1252, 854, 1202, 1967, 188, 956, 678, 82, 212, 1498, 1151, 273, 1242, 1953, 300, 1717, 421, 22, 193, 3, 1280, 1902, 274, 799, 1473, 1658, 1263, 1493, 1162, 1782, 1720, 1234, 638, 1810, 224, 831, 1442, 687, 1302, 1142, 141, 880, 1655, 1862, 774, 1305, 1872, 16, 1577, 1160, 387, 1706, 722, 1786, 674, 1354, 1635, 1742, 54, 162, 1783, 36, 992, 535, 994};
        int coins = 319353;
        System.out.println(maxIceCream(costs, coins));
        System.out.println(maxIceCream1(costs, coins));
    }
}
