package com.cn.view.systemJFrame.Operator.privateTree.jtreecheck;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

//@author Santhosh Kumar T - santhosh@in.fiorano.com 
public class CheckTreeSelectionModel extends DefaultTreeSelectionModel{ 
    private TreeModel model; 
 
    public CheckTreeSelectionModel(TreeModel model){ 
        this.model = model; 
        //DISCONTIGUOUS_TREE_SELECTION:选择可以包含任何数量的项，这些项不必是连续的
        setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION); 
    } 
 
    // tests whether there is any unselected node in the subtree of given path 
    //判断在给定的节点路径子树当中是否有未选中的节点，即判断是否部分选中
    public boolean isPartiallySelected(TreePath path){ 
    	//如果当前选择了路径 path，则返回 true。
        if(isPathSelected(path, true)) 
        	//判断是否有父节点，有则返回false
            return false;
        //返回 selection 中的路径。如果当前没有选择任何内容，则返回 null（或一个空数组）。
        TreePath[] selectionPaths = getSelectionPaths(); 
        if(selectionPaths==null) 
            return false; //没有选择任何内容当然也就既不是部分选定也非全选定，而是为选定，所以返回false
        for(int j = 0; j<selectionPaths.length; j++){ 
            if(isDescendant(selectionPaths[j], path)) 
                return true; 
        } 
        return false; 
    } 
 
    // tells whether given path is selected. 
    // if dig is true, then a path is assumed to be selected, if 
    // one of its ancestor is selected. 
    //如果任意一个子节点被选中，且dig为true的话，该子节点的父节点被选中（包括间接父节点）
    //注意：dig是作为控制条件，当dig为true时，此节点路径所代表的节点为叶子节点
    public boolean isPathSelected(TreePath path, boolean dig){ 
        if(!dig) 
            return super.isPathSelected(path); //如果当前选择了路径 path，则返回 true
        while(path!=null && !super.isPathSelected(path)) 
        	//返回包含除最后一个路径组件之外的此对象所有元素的路径。等于是获取的起所有父节点路径
            path = path.getParentPath(); 
        return path!=null; 
    } 
 
    // is path1 descendant of path2 判断path1是否为path2的子路径
    private boolean isDescendant(TreePath path1, TreePath path2){ 
        Object obj1[] = path1.getPath();
        Object obj2[] = path2.getPath(); 
        for(int i = 0; i<obj2.length; i++){ 
        	//很简单，举例说明：obj1[]为：[根结点,二级节点] obj2[]为：[根结点]
        	//很明显，此时path1是path2的子节点
            if(obj1[i]!=obj2[i]) //只要任意一个对应项不相等则不是
                return false; 
        } 
        return true; 
    } 
 
    public void setSelectionPaths(TreePath[] pPaths){ 
        throw new UnsupportedOperationException("not implemented yet!!!"); 
    } 
 
    public void addSelectionPaths(TreePath[] paths){ 
        // unselect all descendants of paths[] 未选中paths[]当中的所有子路径
        for(int i = 0; i<paths.length; i++){ 
            TreePath path = paths[i]; 
            TreePath[] selectionPaths = getSelectionPaths(); 
            if(selectionPaths==null) 
                break; 
            ArrayList toBeRemoved = new ArrayList(); 
            for(int j = 0; j<selectionPaths.length; j++){ 
                if(isDescendant(selectionPaths[j], path)) 
                    toBeRemoved.add(selectionPaths[j]); 
            } 
            //toArray:按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组；
            //返回数组的运行时类型是指定数组的运行时类型。
            super.removeSelectionPaths((TreePath[])toBeRemoved.toArray(new TreePath[0])); 
            //从选择中移除路径。如果 paths 中的任何路径在选择中，
            //则通知 TreeSelectionListener。如果 paths 为 null，则此方法无效。
        } 
 
        // if all siblings are selected then unselect them and select parent recursively 
        // otherwize just select that path. 
        //如果与之同一级的节点都被选定，未选定自身，那么递归的选定其父级节点
        for(int i = 0; i<paths.length; i++){ 
            TreePath path = paths[i]; 
            TreePath temp = null; 
            while(areSiblingsSelected(path)){ 
                temp = path; 
                if(path.getParentPath()==null) 
                    break; 
                path = path.getParentPath();
            } 
            if(temp!=null){ 
                if(temp.getParentPath()!=null) 
                    addSelectionPath(temp.getParentPath()); 
                else{ 
                    if(!isSelectionEmpty()) 
                        removeSelectionPaths(getSelectionPaths()); 
                    super.addSelectionPaths(new TreePath[]{temp}); 
                } 
            }else 
                super.addSelectionPaths(new TreePath[]{ path}); 
        } 
    } 
 
    // tells whether all siblings of given path are selected. 
    //判断与给定节点同级的节点是否都被选定
    private boolean areSiblingsSelected(TreePath path){ 
        TreePath parent = path.getParentPath(); 
        if(parent==null) 
            return true; 
        Object node = path.getLastPathComponent(); 
        Object parentNode = parent.getLastPathComponent(); 
 
        int childCount = model.getChildCount(parentNode); 
        for(int i = 0; i<childCount; i++){ 
            Object childNode = model.getChild(parentNode, i); 
            if(childNode==node) 
                continue; 
            if(!isPathSelected(parent.pathByAddingChild(childNode))) 
                return false; 
        } 
        return true; 
    } 
 
    //移除所有被选定的节点路径
    public void removeSelectionPaths(TreePath[] paths){ 
        for(int i = 0; i<paths.length; i++){ 
            TreePath path = paths[i]; 
            if(path.getPathCount()==1) //返回路径中的元素数
                super.removeSelectionPaths(new TreePath[]{ path}); 
            else 
                toggleRemoveSelection(path); 
        } 
    } 
 
    // if any ancestor node of given path is selected then unselect it 
    //  and selection all its descendants except given path and descendants. 
    // otherwise just unselect the given path 
    //取消选定已选定的某个父节点，并选中所有它的子节点（除给定的节点及其子节点），否则仅不选定给定的节点
    private void toggleRemoveSelection(TreePath path){ 
        Stack stack = new Stack(); 
        TreePath parent = path.getParentPath(); 
        //如果父节点不为空，且父节点未被选中，循环将所有的父节点加载
        while(parent!=null && !isPathSelected(parent)){ 
            stack.push(parent); 
            parent = parent.getParentPath(); 
        } 
        if(parent!=null) 
            stack.push(parent); 
        else{ 
            super.removeSelectionPaths(new TreePath[]{path}); 
            return; 
        } 
 
        while(!stack.isEmpty()){ 
            TreePath temp = (TreePath)stack.pop(); 
            TreePath peekPath = stack.isEmpty() ? path : (TreePath)stack.peek(); 
            Object node = temp.getLastPathComponent(); 
            Object peekNode = peekPath.getLastPathComponent(); 
            int childCount = model.getChildCount(node); 
            for(int i = 0; i<childCount; i++){ 
                Object childNode = model.getChild(node, i); 
                if(childNode!=peekNode) 
                    super.addSelectionPaths(new TreePath[]{temp.pathByAddingChild(childNode)}); 
            } 
        } 
        super.removeSelectionPaths(new TreePath[]{parent}); 
    } 
}
