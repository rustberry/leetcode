/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#include <stdio.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    if (l1 != NULL) printf("ListNode* l1->val %d\n", l1->val);
    if (l1 == NULL)
        return l2;
    if (l2 == NULL)
        return l1;
    
    int v1 = l1->val, v2 = l2->val;
    if (v1 < v2) {
        l1->next = mergeTwoLists(l1->next, l2);
        return l1;
    } else {
        l2->next = mergeTwoLists(l2->next, l1);
        return l2;
    }
}

/*
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode l3, *ptr;
    l3.val = 0; l3.next = NULL;
    ptr = &l3;
    while (l1 && l2) {
        if (l1 != NULL) printf("l1->val %d, l2->val %d\n", l1->val, l2->val);
        int v1 = l1->val, v2 = l2->val;
        if (v1 < v2) {
            ptr->next = l1;
            l1 = l1->next;
        } else {
            ptr->next = l2;
            l2 = l2->next;
        }
        ptr = ptr->next;
    }
    
    if (l1 == NULL)
        ptr->next = l2;
    if (l2 == NULL)
        ptr->next = l1;
    
    // printf("ptr->next->val %d, l3.val %d\n", ptr->val, l3.next->val);
    return l3.next;
}
*/