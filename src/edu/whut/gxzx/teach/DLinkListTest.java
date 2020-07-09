package edu.whut.gxzx.teach;

class DLinkList {
	int data;
	DLinkList prior, next;
	

	public DLinkList buildDLinkList(int[] arr) {
		DLinkList head = new DLinkList();
		head.next = null;
		head.prior = null;
		head.data = 0;
		DLinkList r = head;
		int count = 0;
		while (count < arr.length) {
			DLinkList p = new DLinkList();
			p.data = arr[count++];
			p.next = r.next;
			p.prior = r;
			r.next = p;
			r = p;
		}
		return head;
	}

	public void print(DLinkList head) {
		DLinkList p=head.next;
		while (p!=null) {
			System.out.print(p.data+" ");
			p=p.next;
		}
	}
	
	public DLinkList insert(DLinkList head,int posi,int value) {
		DLinkList p=head;
		int count=0;
		while (count<posi) {
			p=p.next;
			count++;
		}
		DLinkList q=new DLinkList();
		q.data=value;
		q.next=p.next;
		q.prior=p;
		p.next.prior=q;
		p.next=q;
		return head;
	}
	
	public DLinkList delete(DLinkList head,int posi) {
		DLinkList p=head;
		int count=0;
		while (count<posi) {
			p=p.next;
			count++;
		}
		p.next.next.prior=p;
		p.next=p.next.next;
		
		return head;
	}

}

public class DLinkListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[]{1,3,5,5,5,7,12,15,15,20};
		DLinkList hDLinkList=new DLinkList();
		DLinkList list=hDLinkList.buildDLinkList(arr);
		hDLinkList.print(list);
		System.out.println();
		hDLinkList.insert(list,5,99);
		hDLinkList.print(list);
		
		System.out.println();
		hDLinkList.delete(list, 8);
		hDLinkList.print(list);
	}

}
