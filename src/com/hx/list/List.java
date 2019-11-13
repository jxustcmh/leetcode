package com.hx.list;

/**
 * @author jxlgcmh
 * @date 2019-11-13 23:03
 * @description
 */
public class List {
    public static void main(String[] args) {
        List list =new List();
        ListNode listNode1 =new ListNode(1);
        ListNode listNode2 =new ListNode(2);
        ListNode listNode3 =new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        ListNode listNode4 =new ListNode(2);
        ListNode listNode5 =new ListNode(3);
        ListNode listNode6 =new ListNode(5);
        listNode4.next=listNode5;
        listNode5.next=listNode6;

        list.mergeTwoLists(listNode1,listNode4);
    }

    /**
     *将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1 链表1
     * @param l2 链表2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    /**
     *  非递归方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1==null?l2:l1;
        return res.next;
    }
}
