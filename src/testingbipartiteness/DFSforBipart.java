/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testingbipartiteness;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author TofixXx
 */
public class DFSforBipart {
    
    private boolean marked[];
    private boolean part[];
    private boolean isBipart = true;
    private HashSet<Integer>[] adjList;
    
    DFSforBipart(HashSet<Integer> AList[], int V, int E)
    {
        this.adjList = AList;
        marked = new boolean[V + 1];
        part = new boolean[V + 1];
        Iterator<Integer> it = adjList[1].iterator();
        marked[1] = true;
        part[1] = true;
        while(it.hasNext())
        {
            int S = it.next();
            if(!marked[S])
            {
                marked[S] = true;
                part[S] = !part[1];
                search(S);
            }
            if(!isBipart)
            {
                break;
            }
        }
    }
    
    private void search(int V)
    {
        Iterator<Integer> it = adjList[V].iterator();
        while(it.hasNext())
        {
            int S = it.next();
            if(!marked[S])
            {
                marked[S] = true;
                part[S] = !part[V];
                search(S);
            }
            else if(part[S] == part[V])
            {
                isBipart = false;
            }
            if(!isBipart)
            {
                return;
            }
        }
    }
    
    public boolean isBipart()
    {
        return isBipart;
    }
}
