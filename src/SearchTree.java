public class SearchTree implements NodeList {

        private ListItem root = null;

        @Override
        public ListItem getRoot() {
            return root;
        }

        @Override
        public boolean addItem(ListItem listItem) {
            if (root == null) {
                // empty tree, listItem become root
                root = listItem;
                return true;
            }

            // otherwise start comparing
            ListItem currentItem = root;
            while (currentItem != null) {
                int comparison = currentItem.compareTo(listItem);
                if (comparison < 0) {
                    // listItem is greater, move right if possible
                    if (currentItem.next()==null) {
                        // no node to the right, so add at this point
                        currentItem.setNext(listItem);
                        return true;
                    } else {
                        currentItem = currentItem.next();
                    }
                } else if (comparison > 0) {
                    // listItem is smaller, move left if possible
                    if (currentItem.previous()==null) {
                        // no node to the left, so add at this point
                        currentItem.setPrevious(listItem);
                        return true;
                    } else {
                        currentItem = currentItem.previous();
                    }
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
            ListItem parentItem = currentItem;

            while (currentItem != null) {
                int comparison = currentItem.compareTo(listItem);

                if (comparison < 0) {
                    parentItem = currentItem;
                    currentItem = currentItem.next();
                } else if (comparison > 0) {
                    parentItem = currentItem;
                    currentItem = currentItem.previous();
                } else {
                    // found item
                    performRemove(currentItem, parentItem);
                    return true;
                }
            }

            System.out.println("No existing: " + listItem.getValue());
            return false;
        }

        private void performRemove(ListItem currentItem, ListItem parentItem) {
            System.out.println("Deleting:" + currentItem.getValue());
            if (currentItem.next()==null) {
                // no right branch, make parent link to the left branch
                if (parentItem.next() == currentItem) {
                    // currentItem is the right child of parent
                    parentItem.setNext(currentItem.previous());
                } else if (parentItem.previous() == currentItem) {
                    // currentItem is the left child of parent
                    parentItem.setPrevious(currentItem.previous());
                } else {
                    // parentItem == currentItem which is root
                    root = currentItem.previous();
                }
            } else if (currentItem.previous() == null) {
                // no left branch, make parent link to the right branch
                if (parentItem.next() == currentItem) {
                    // currentItem is the right child of parent
                    parentItem.setNext(currentItem.next());
                } else if (parentItem.previous() == currentItem) {
                    // currentItem is the left child of parent
                    parentItem.setPrevious(currentItem.next());
                } else {
                    // parentItem == currentItem which is root
                    root = currentItem.next();
                }
            } else {
                // both left and right exist
                // from the right branch, find the smallest value
                ListItem current = currentItem.next();
                ListItem leftMostParent = currentItem;
                while (current.previous()!=null) {
                    leftMostParent = current;
                    current = current.previous();
                }

                // now current is the smallest node in the right branch
                // put it into current deleting node
                currentItem.setValue(current.getValue());

                // delete smallest node
                if (leftMostParent == currentItem) {
                    // no leftmost node, so current points to
                    // the smallest node
                    currentItem.setNext(current.next());
                } else {
                    // set the smallest node's parent to point to
                    // the smallest node's right child
                    leftMostParent.setPrevious(current.next());
                }
            }
        }

        @Override
        public void traverse(ListItem listItem) {
            // recursive method
            if (listItem != null) {
                traverse(listItem.previous());
                System.out.println(listItem.getValue());
                traverse(listItem.next());
            }
        }

    }

