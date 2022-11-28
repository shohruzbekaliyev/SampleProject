public class MyLinkedList implements NodeList {
    private ListItem root = null;

    @Override
    public ListItem getRoot() {
        return root;
    }
    @Override
    public boolean addItem(ListItem listItem) {
        if (root == null) {
            root = listItem;
            return true;
        }
        ListItem currentItem = root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(listItem);
            if (comparison < 0) { // listItem is greater.
                if (currentItem.next()==null) {
                    currentItem.setNext(listItem).setPrevious(currentItem);
                    return true;
                } else {
                    currentItem = currentItem.next();
                }
            } else if (comparison > 0) { // listItem is smaller
                if (currentItem.previous()==null) {
                    currentItem.setPrevious(listItem).setNext(currentItem);
                    root = listItem;
                } else {
                    currentItem.previous().setNext(listItem).setPrevious(currentItem.previous());
                    currentItem.setPrevious(listItem).setNext(currentItem);
                }
                return true;
            } else {
                System.out.println("Duplicated item : " + listItem.getValue() );
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        ListItem currentItem = this.getRoot();
        while (currentItem != null) {
            int comparison = currentItem.compareTo(listItem);
            if (comparison == 0) {
                System.out.println("Deleting item : " + listItem.getValue());
                if (currentItem.previous()==null) {
                    if (currentItem.next()!=null) {
                        root = currentItem.next();
                        root.setPrevious(null);
                    } else {
                        root = null;
                    }
                    return true;
                }
                if (currentItem.next()==null) {
                    currentItem.previous().setNext(null);
                    return true;
                }
                currentItem.previous().setNext(currentItem.next()).setPrevious(currentItem.previous());
                return true;
            } else {
                currentItem = currentItem.next();
            }
        }

        System.out.println("No existing: " + listItem.getValue());
        return false;

    }

    @Override
    public void traverse(ListItem listItem) {
        if (root == null) {
            System.out.println("Empty list..");
        } else {
            ListItem currentItem = root;
            while (currentItem != null) {
                System.out.println(currentItem.getValue());
                currentItem = currentItem.next();
            }
        }

    }

}