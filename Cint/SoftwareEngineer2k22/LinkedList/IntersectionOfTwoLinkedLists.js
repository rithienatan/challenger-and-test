function getIntersection(list1, list2) {
    // fill in implementation for method
    let listA = list1.head;
    let listB = list2.head;

    while(listA.val !== listB.val) {
        listA = listA === null ? list2 : listA.next;
        listB = listB === null ? list1 : listB.next;
    }

    let newlist = new LinkedList();
    newlist.append(listA.val);

    console.log(newlist);

    return newlist;
}
  
// Supporting data structures
  
class LinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
    }
  
    prepend(newVal) {
        const currentHead = this.head;
        const newNode = new Node(newVal);
        newNode.next = currentHead;
        this.head = newNode;
  
        if (!this.tail) {
            this.tail = newNode;
        }
    }
  
    append(newVal) {
        const newNode = new Node(newVal);
        if (!this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
  
    isPresent(val) {
        let head = this.head;
        while (head) {
            if (head.val === val) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
  
    toArray() {
        const toPrint = [];
        let currNode = this.head;
        while (currNode) {
            toPrint.push(currNode.val);
            currNode = currNode.next;
        }
        return toPrint;
    }
  
    toString() {
        const toPrint = [];
        let currNode = this.head;
  
        while (currNode) {
            toPrint.push(currNode.val);
            currNode = currNode.next;
        }
  
        return toPrint.join(' -> ');
    }
}
  
function Node(val) {
    this.val = val;
    this.next = null;
}
  
try {
    let list1 = new LinkedList();
    list1.prepend(25);
    list1.prepend(15);
    list1.prepend(5);
    list1.prepend(9);
    let list2 = new LinkedList();
    list2.prepend(14);
    list2.prepend(15);
    list2.prepend(7);
    list2.prepend(13);
    console.log(assertSameMembers(getIntersection(list1, list2).toArray(), [15]));
  
    console.log(
      'PASSED: Getting the insection of two lists with node `15` should return a list of `15`.'
    );
} catch (err) {
    console.log(err);
}
  
function assertSameMembers(a, b) {
    return JSON.stringify(a.sort()) === JSON.stringify(b.sort());
}  