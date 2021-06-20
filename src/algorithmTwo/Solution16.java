package algorithmTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//1600. 皇位继承顺序
public class Solution16 {
    class ThroneInheritance {
        String oriKing = "";

        class Person {
            String name;
            String father;
            List<Person> children = new ArrayList<>();
            boolean isDeath;
        }

        HashMap<String, Person> personMap = new HashMap();

        public ThroneInheritance(String kingName) {
            oriKing = kingName;
            Person person = new Person();
            person.name = kingName;
            personMap.put(kingName, person);
        }

        public void birth(String parentName, String childName) {
            Person child = new Person();
            child.name = childName;
            child.father = parentName;

            Person father = personMap.get(parentName);
            father.children.add(child);

            personMap.put(parentName, father);
            personMap.put(childName, child);
        }

        public void death(String name) {
            personMap.get(name).isDeath = true;
        }

        public List<String> getInheritanceOrder() {
            Person person = personMap.get(oriKing);
            return dfs(person);
        }

        public List<String> dfs(Person person) {
            List<String> res = new ArrayList<>();
            if (!person.isDeath) {
                res.add(person.name);
            }
            for (Person child : person.children) {
                res.addAll(dfs(child));
            }
            return res;
        }
    }

    void Successor(String x, List<String> curOrder) {
//            如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
//    如果 x 是国王，那么返回 null
//    否则，返回 Successor(x 的父亲, curOrder)
//    否则，返回 x 不在 curOrder 中最年长的孩子
    }

    public static void main(String[] args) {
//        ThroneInheritance throneInheritance = new ThroneInheritance("king");
//        List<String> inheritanceOrder = throneInheritance.getInheritanceOrder();
//        throneInheritance.birth("king", "andy");
//        throneInheritance.birth("king", "bob");
//        throneInheritance.birth("king", "catherine");
//        throneInheritance.birth("andy", "matthew");
//        throneInheritance.birth("bob", "alex");
//        throneInheritance.birth("bob", "asha");
//        System.out.println(inheritanceOrder.toString());
    }


}
