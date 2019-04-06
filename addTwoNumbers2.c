/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode l3, *ptr;
    l3.val = 0;
    ptr = &l3;
    int sum, carry = 0;
    while (l1 != NULL && l2 != NULL) {
        sum = l1->val + l2->val + carry;
        if (sum > 9) {
            sum -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        ptr->next = (struct ListNode*)malloc(sizeof(struct ListNode));
        ptr->next->val = sum;
        
        ptr = ptr->next;
        l1 = l1->next;
        l2 = l2->next;
    }
    while (carry == 1) {
        if (l1 == NULL && l2 == NULL) {
            ptr->next = (struct ListNode*)malloc(sizeof(struct ListNode));
            ptr->next->val = 1;
            ptr = ptr->next;
            break;
        } else if (l1 == NULL) {
            l2->val += 1;
            carry = 0;
            ptr->next = l2;
            if (l2->val > 9) {
                l2->val -= 10;
                carry = 1;
                l2 = l2->next;
                ptr = ptr->next;
            }
        } else {
            l1->val += 1;
            carry = 0;
            ptr->next = l1;
            if (l1->val > 9) {
                l1->val -= 10;
                carry = 1;
                l1 = l1->next;
                ptr = ptr->next;            
            }
        }   
    }
    if (l1 == NULL) {
        ptr->next = l2;
    } else {
        ptr->next = l1;
    }
    return l3.next;
}