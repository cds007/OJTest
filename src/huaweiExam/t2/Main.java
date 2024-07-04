package huaweiExam.t2;

import java.util.*;

public class Main {

    static class Cell {
        Map<Integer, Integer> map;
        int nums = 0;//使用次数
        int time = 0;//上一次使用时间

        Cell(int a, int b) {
            map = new HashMap<>();
            map.put(a, b);
        }

        Cell(int a, int b, int time) {
            map = new HashMap<>();
            map.put(a, b);
            this.time = time;
        }
    }

    public static void main(String[] args) {
        //1.需要存储 键值对、键值对的使用数、键值对的上一次使用时间。时间的话用每一行其实可以存储次
        List<Cell> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int cap = 0;
        int time = 0;//绝对时间，每一行算一个时间
        while (in.hasNextLine()) {
            String str = in.nextLine();
            time++;
            if (str.charAt(0) == 'c') {
                //设置容量
                str = in.nextLine();
                time++;
                cap = Integer.valueOf(str);
            } else if (str.charAt(0) == 'w') {
                str = in.nextLine();
                str = str.substring(0,str.length()-1);
                time++;
                int cnt = Integer.valueOf(str);
                for (int i = 0; i < cnt; i++) {
                    str = in.nextLine();
                    time++;
                    if (list.size() < cap) {
                        //没满
                        String[] nums = str.split(" ");
                        if (list.isEmpty()) {
                            //如果是空的
                            Cell cell = new Cell(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]), time);
                            list.add(cell);
                        } else {
                            //找一下有没有一样的
                            boolean flag = false;
                            for (Cell cellall :
                                    list) {
                                if (cellall.map.containsKey(Integer.valueOf(nums[0]))) {
                                    flag = true;
                                    //如果之前就有的话，那么要更新一下
                                    cellall.map.put(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]));
                                    //刷新时间
                                    cellall.time = time;
                                    //次数加1
                                    cellall.nums++;
                                }
                            }
                            if (!flag){//没有一样的
                                Cell cell = new Cell(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]), time);
                                list.add(cell);
                            }
                        }
                    } else {
                        //满了，要删了
                        //先判断有没有
                        String[] nums = str.split(" ");
                        boolean flag = false;
                        for (Cell cellall :
                                list) {
                            if (cellall.map.containsKey(Integer.valueOf(nums[0]))) {
                                flag = true;
                                //如果之前就有的话，那么要更新一下
                                cellall.map.put(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]));
                                //刷新时间
                                cellall.time = time;
                                //次数加1
                                cellall.nums++;
                            }
                        }
                        if (!flag) {
                            //真要删了
                            list.sort((a, b) -> {
                                if (a.nums != b.nums) {
                                    return a.nums - b.nums;//使用次数升序排序
                                }
                                if (a.time != b.time) {
                                    return a.time - b.time;//再按时间升序排序
                                }
                                return a.time - b.time;
                            });
                            list.remove(0);//删第一个
                        }
                    }
                }
            } else if (str.charAt(0) == 'r') {
                //读操作
                str = in.nextLine();
                time++;
                int num = Integer.valueOf(str);
                for (Cell cellall :
                        list) {
                    if (cellall.map.containsKey(num)) {
                        //刷新时间
                        cellall.time = time;
                        //次数加1
                        cellall.nums++;
                    }
                }
            } else if (str.charAt(0)=='q') {
                str = in.nextLine();
                time++;
                int num = Integer.valueOf(str);
                for (Cell cellall :
                        list) {
                    if (cellall.map.containsKey(num)) {
                        //刷新时间
                        System.out.println(cellall.map.get(num));
                        return;
                    }
                }
                System.out.println(-1);
                return;
            }
        }
    }
}
