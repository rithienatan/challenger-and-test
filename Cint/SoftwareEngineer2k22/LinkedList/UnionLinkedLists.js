function getUnion(list1, list2) {
    // implement a method to get the union
    let newlist = new LinkedList();

    while(list1.tail !== null)
    {
        
    }//end while


    console.log(newlist.toString())

    return(newlist);
}

function Node(val) {
    this.val = val;
    this.next = null;
}

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
    assertSameMembers(
        getUnion(list1, list2).toArray(),
        [13, 7, 14, 25, 15, 5, 9]
    );

    console.log(
        'PASSED: Expected the following: `let list1 = new LinkedList; list1.prepend(25); list1.prepend(15); list1.prepend(5); list1.prepend(9);  let list2 = new LinkedList; list2.prepend(14); list2.prepend(15); list2.prepend(7); list2.prepend(13); getUnion(list1, list2).toArray();`to have members `[13, 7, 14, 25, 15, 5, 9]`'
    );
} catch (err) {
    console.log(err);
}

function assertSameMembers(a, b) {
    return JSON.stringify(a.sort()) === JSON.stringify(b.sort());
}
