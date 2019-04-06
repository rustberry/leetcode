/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode *pre, *cur, *next;  // struct ListNode* pre, cur is false!
    pre = NULL;
    cur = head;
    while (cur != NULL) {
        next = cur->next;
        
        cur->next = pre;
        pre = cur;
        cur = next;
    }
    return pre;
}

struct ListNode* reverseListRecursive(struct ListNode* head) {
    
}

/*
struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode dummyH, *preC, *cur, *sentinel;
    dummyH.val = 0;
    dummyH.next = head;
    preC = &dummyH;
    cur = head;
    sentinel = NULL;
    
    while (sentinel != dummyH.next) {
        while (cur->next != sentinel) {
            preC->next = cur->next;
            cur->next = cur->next->next;
            preC->next->next = cur;
            
            preC = preC->next;
        }
        sentinel = cur;
        cur = dummyH.next;
        preC = &dummyH;
    }
    return dummyH.next;
}
*/