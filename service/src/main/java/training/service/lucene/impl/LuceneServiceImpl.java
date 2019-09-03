package training.service.lucene.impl;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Service;
import training.service.lucene.LuceneService;
import java.nio.file.Files;
import java.nio.file.Path;

@Service("luceneService")
public class LuceneServiceImpl implements LuceneService {

    @Override
    public String getMessage() throws Exception {
        return "luceneService wata";
    }

    public IndexWriter getIndexWriter(String path) throws Exception{
        StandardAnalyzer analyzer = new StandardAnalyzer();
        Path indexPath = Files.createTempDirectory(path);
        FSDirectory directory = FSDirectory.open(indexPath);
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        return indexWriter;
    }
}
