package mike.code.oj.leetcode;

import java.util.*;

/**
 * @author Mike
 * @project oj.code
 * @date 21/05/2017, 10:15 AM
 * @e-mail mike@mikecoder.cn
 */


public class DesignInMemoryFileSystem {
    
    static class FileSystem {
        
        class Content {
            public HashMap<String, Content> nexts    = new HashMap<String, Content>();
            public String                   contents = "";
            public String                   name     = "";
            
            public boolean isFile = false;
            
            @Override
            public String toString() {
                return "Content{" + "contents='" + contents + '\'' + ", name='" + name + '\'' + ", isFile=" + isFile + '}';
            }
        }
        
        private Content root;
        
        public FileSystem() {
            root = new Content();
            root.nexts = new HashMap<String, Content>();
        }
        
        ArrayList<String> dividePath(String path) {
            String[] paths = path.split("/");
            ArrayList<String> _path = new ArrayList<String>();
            for (int i = 0; i < paths.length; i++) {
                if (paths[i].length() == 0) {
                    continue;
                } else {
                    _path.add(paths[i]);
                }
            }
            return _path;
        }
        
        public List<String> ls(String path) {
            ArrayList<String> paths = dividePath(path);
            
            Content current = root;
            for (String nextPath : paths) {
                current = current.nexts.get(nextPath);
            }
            LinkedList<String> res = new LinkedList<String>();
            if (current.isFile) {
                res.add(current.name);
                return res;
            } else {
                for (Content content : current.nexts.values()) {
                    res.add(content.name);
                }
                Collections.sort(res);
                return res;
            }
        }
        
        public void mkdir(String path) {
            addContentToFile(path, null);
        }
        
        public void addContentToFile(String filePath, String content) {
            ArrayList<String> paths = dividePath(filePath);
            Content current = root;
            for (int i = 0; i < paths.size(); i++) {
                if (!current.nexts.containsKey(paths.get(i))) {
                    Content dir = new Content();
                    dir.name = paths.get(i);
                    current.nexts.put(dir.name, dir);
                }
                current = current.nexts.get(paths.get(i));
                if (i == paths.size() - 1 && content != null) {
                    current.contents += content;
                    current.isFile = true;
                }
            }
        }
        
        public String readContentFromFile(String filePath) {
            ArrayList<String> paths = dividePath(filePath);
            Content current = root;
            for (int i = 0; i < paths.size(); i++) {
                current = current.nexts.get(paths.get(i));
            }
            return current.contents;
        }
    }
    
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir("/z");
        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.ls("/z"));
        fileSystem.mkdir("/r");
        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.ls("/r"));
        fileSystem.addContentToFile("/z/a", "fff");
        System.out.println(fileSystem.readContentFromFile("/z/a"));
        System.out.println(fileSystem.ls("/"));

//        fileSystem.mkdir("/a/b/c");
//        System.out.println(fileSystem.ls("/a"));
//        fileSystem.addContentToFile(("/a/b/c/d"), "hello");
//        fileSystem.addContentToFile(("/a/b/c/d"), "hello");
//        System.out.println(fileSystem.ls("/a/b/c/d"));
//        fileSystem.ls("/");
//        System.out.println(fileSystem.ls("/"));
//        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));
    }
}
