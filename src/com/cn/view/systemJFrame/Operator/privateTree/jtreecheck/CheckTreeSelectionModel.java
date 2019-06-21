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
        //DISCONTIGUOUS_TREE_SELECTION:ѡ����԰����κ����������Щ�����������
        setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION); 
    } 
 
    // tests whether there is any unselected node in the subtree of given path 
    //�ж��ڸ����Ľڵ�·�����������Ƿ���δѡ�еĽڵ㣬���ж��Ƿ񲿷�ѡ��
    public boolean isPartiallySelected(TreePath path){ 
    	//�����ǰѡ����·�� path���򷵻� true��
        if(isPathSelected(path, true)) 
        	//�ж��Ƿ��и��ڵ㣬���򷵻�false
            return false;
        //���� selection �е�·���������ǰû��ѡ���κ����ݣ��򷵻� null����һ�������飩��
        TreePath[] selectionPaths = getSelectionPaths(); 
        if(selectionPaths==null) 
            return false; //û��ѡ���κ����ݵ�ȻҲ�ͼȲ��ǲ���ѡ��Ҳ��ȫѡ��������Ϊѡ�������Է���false
        for(int j = 0; j<selectionPaths.length; j++){ 
            if(isDescendant(selectionPaths[j], path)) 
                return true; 
        } 
        return false; 
    } 
 
    // tells whether given path is selected. 
    // if dig is true, then a path is assumed to be selected, if 
    // one of its ancestor is selected. 
    //�������һ���ӽڵ㱻ѡ�У���digΪtrue�Ļ������ӽڵ�ĸ��ڵ㱻ѡ�У�������Ӹ��ڵ㣩
    //ע�⣺dig����Ϊ������������digΪtrueʱ���˽ڵ�·��������Ľڵ�ΪҶ�ӽڵ�
    public boolean isPathSelected(TreePath path, boolean dig){ 
        if(!dig) 
            return super.isPathSelected(path); //�����ǰѡ����·�� path���򷵻� true
        while(path!=null && !super.isPathSelected(path)) 
        	//���ذ��������һ��·�����֮��Ĵ˶�������Ԫ�ص�·���������ǻ�ȡ�������и��ڵ�·��
            path = path.getParentPath(); 
        return path!=null; 
    } 
 
    // is path1 descendant of path2 �ж�path1�Ƿ�Ϊpath2����·��
    private boolean isDescendant(TreePath path1, TreePath path2){ 
        Object obj1[] = path1.getPath();
        Object obj2[] = path2.getPath(); 
        for(int i = 0; i<obj2.length; i++){ 
        	//�ܼ򵥣�����˵����obj1[]Ϊ��[�����,�����ڵ�] obj2[]Ϊ��[�����]
        	//�����ԣ���ʱpath1��path2���ӽڵ�
            if(obj1[i]!=obj2[i]) //ֻҪ����һ����Ӧ��������
                return false; 
        } 
        return true; 
    } 
 
    public void setSelectionPaths(TreePath[] pPaths){ 
        throw new UnsupportedOperationException("not implemented yet!!!"); 
    } 
 
    public void addSelectionPaths(TreePath[] paths){ 
        // unselect all descendants of paths[] δѡ��paths[]���е�������·��
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
            //toArray:���ʵ�˳�򣨴ӵ�һ�������һ��Ԫ�أ����ذ������б�������Ԫ�ص����飻
            //�������������ʱ������ָ�����������ʱ���͡�
            super.removeSelectionPaths((TreePath[])toBeRemoved.toArray(new TreePath[0])); 
            //��ѡ�����Ƴ�·������� paths �е��κ�·����ѡ���У�
            //��֪ͨ TreeSelectionListener����� paths Ϊ null����˷�����Ч��
        } 
 
        // if all siblings are selected then unselect them and select parent recursively 
        // otherwize just select that path. 
        //�����֮ͬһ���Ľڵ㶼��ѡ����δѡ��������ô�ݹ��ѡ���丸���ڵ�
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
    //�ж�������ڵ�ͬ���Ľڵ��Ƿ񶼱�ѡ��
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
 
    //�Ƴ����б�ѡ���Ľڵ�·��
    public void removeSelectionPaths(TreePath[] paths){ 
        for(int i = 0; i<paths.length; i++){ 
            TreePath path = paths[i]; 
            if(path.getPathCount()==1) //����·���е�Ԫ����
                super.removeSelectionPaths(new TreePath[]{ path}); 
            else 
                toggleRemoveSelection(path); 
        } 
    } 
 
    // if any ancestor node of given path is selected then unselect it 
    //  and selection all its descendants except given path and descendants. 
    // otherwise just unselect the given path 
    //ȡ��ѡ����ѡ����ĳ�����ڵ㣬��ѡ�����������ӽڵ㣨�������Ľڵ㼰���ӽڵ㣩���������ѡ�������Ľڵ�
    private void toggleRemoveSelection(TreePath path){ 
        Stack stack = new Stack(); 
        TreePath parent = path.getParentPath(); 
        //������ڵ㲻Ϊ�գ��Ҹ��ڵ�δ��ѡ�У�ѭ�������еĸ��ڵ����
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
