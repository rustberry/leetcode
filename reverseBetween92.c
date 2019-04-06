/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
// struct ListNode {
    // int val;
    // struct ListNode *next;
// };
 
struct ListNode* reverseBetween(struct ListNode* head, int m, int n) {
    struct ListNode *pre, *cur, *next, *preM, dummyH;
    if (m == n) return head;
    dummyH.val = 0;
    dummyH.next = head;
    pre = &dummyH;
    cur = head;
    for (int count = 1; count < m; ++count) {
        pre = cur;
        cur = cur->next;
    }
    preM = pre;
    cur = cur->next;
    pre = pre->next;
    
    for (int count = m+1; count <= n; ++count) {
        next = cur->next;
        cur->next = pre;
        pre = cur;
        cur = next;
    }
    preM->next->next = cur;
    preM->next = pre;
    return dummyH.next;
}