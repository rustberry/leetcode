/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode *slow, *fast;
    int count = 1;  // count from 1
    slow = fast = head;
    while (fast->next != NULL) {
        slow = slow->next;
        fast = fast->next;
        count += 1;
        if (fast->next == NULL) {
            break;
        }
        fast = fast->next;
        count += 1;
        
    }
    n = count - n + 1;
    
    if (n == 1) {
        return head->next;
    }
    count = 2;  // assume that len >= 2
    struct ListNode *pre, *cur;
    pre = head;
    cur = head->next;
    while (count < n) {
        pre = pre->next;
        cur = cur->next;
        count++;
    }
    pre->next = cur->next;
    return head;
}

/*
[1,2,3,4,5]
5
[1,2,3,4,5]
2
[1,2]
2
[1,2]
1
*/