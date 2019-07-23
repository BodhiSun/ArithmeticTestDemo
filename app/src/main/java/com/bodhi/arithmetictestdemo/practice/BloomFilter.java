package com.bodhi.arithmetictestdemo.practice;

/**
 * @author : Sun
 * @version : 1.0
 * create time : 2019/7/23 18:30
 * desc :认识布隆过滤器 即某种类型的集合
 *
 * 布隆过滤器:bit类型的一个数组 用一个bit表示一个元素 并标识是否存在该元素 存在为1 不存在为0
 * 应用场景：用于检索一个元素是否在一个集合中
 * 优点：空间效率和查询时间都比一般的算法要好的多
 * 缺点：是有一定的误识别率和删除困难。失误率(宁可错杀1000也不放过1个这种失误，就是错的不会漏掉，对的可能误报)
 *
 *
 */
public class BloomFilter {

    /**
     * 示例1：做一个0~32000个bit类型的数组 判断数30000是否存在
     */
    public static void test(){
        //1000个整数可以表示32000个比特位 即可以表示32000个元素是否存在
        int[]arr = new int[1000];//一个整型4个字节byte(B) 一个字节占8个比特位bit(b)

        int index = 30000;
        //给定一个数先判断在哪个整数
        int intIndex = index/32;
        //在判断在这个整数的哪个比特位
        int bitIndex = 3000%32;

        //把对应整数的对应bit位置为1 arr里的元素初始值都是0(比特位表示 4组00000000) 1<<bitIndex表示2^bitIndex
        arr[intIndex] = (arr[intIndex]|(1<<bitIndex));

    }

    /**
     * 示例2：设计一个url黑名单 每当用户访问某url时先判断是否在黑名单中 是就返回空 不是就正常返回url
     * 布隆过滤器：准备0~m-1 长度数组 准备K个hash函数 ，如果一个url在经过K个hash函数算出的结果 在数组上
     * 对应的bit位都为1 则次url在黑名单中 只要有一个不为1则认为不在黑名单中
     *
     * 特征：准备的数组长度越大失误率会越低 空间越小失误率会越高
     *
     * hash函数bit类型的数组空间要开多大是由样本量和预期失误率决定 有一个公式：
     * m=-(n*lnp) / (ln2)^2
     * m为需要开的空间 单位为bit
     * n为样本量
     * ln为自然对数 lnp以e为底p的对数 自然对数的底e是由一个重要极限给出的，其值约等于2.7182818…无限不循环小数，是一个超越数。
     * p为预期失误率
     *
     * hash函数个数也有一个公式：
     * K=ln2*(m/n)=0.7*(m/n)
     * k为hash函数的经典个数
     *
     * 当m和k向上取整之后预期失误率有一个公式：
     * （1-e^(-(n*k)/m))^k
     *
     */
    public static void test2(){



    }

}
