package com.affine.yupao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 测试类
 */
@SpringBootTest
class MyApplicationTest {

    @Test
    void testDigest() throws NoSuchAlgorithmException {
        String newPassword = DigestUtils.md5DigestAsHex(("abcd" + "mypassword").getBytes());
        System.out.println(newPassword);
    }

    @Test
    void contextLoads() {
        // 假设我们有如下两个内容相同但顺序不同的List
        List<Integer> listA = new ArrayList<>(Arrays.asList(1, 3, 5, 2, 4));
        List<Integer> listB = new ArrayList<>(Arrays.asList(5, 2, 1, 3, 4));

        // 使用HashSet或LinkedHashSet来快速找到共同元素并保持A的顺序
        Set<Integer> setA = new LinkedHashSet<>(listA);
        List<Integer> sortedB = new ArrayList<>(setA);

        // 确保B中的所有元素都在A中，移除多余的元素
        sortedB.retainAll(listB);

        // 如果sortedB现在与A内容相同且顺序一致，那么转换成功
        System.out.println("Sorted B: " + sortedB);

        // 若B可能包含A中没有的元素，但在内容相同的前提下按A的顺序排列：
        // 可以进一步对B中的每个元素按照A的顺序找到其正确的位置插入
        List<Integer> orderedB = new ArrayList<>();
        for (Integer element : listA) {
            if (listB.contains(element)) {
                orderedB.add(element);
                listB.remove(element); // 移除已添加的元素，防止重复
            }
        }

        // 确保所有B中的元素都已处理
        assert listB.isEmpty();

        System.out.println("Ordered B: " + orderedB);
    }
}
