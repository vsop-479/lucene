package training.service.lucene.impl;

import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import training.service.lucene.LuceneService;
import training.util.json.JsonUtil;
import java.util.List;
import java.util.Map;

public class DNSService extends LuceneServiceImpl implements LuceneService {
    public void run(String path, List<byte[]> dataList) throws Exception {
        IndexWriter indexWriter = getIndexWriter(path);
        bulk(indexWriter, dataList);
    }
    public void bulk(IndexWriter indexWriter, List<byte[]> dataList) throws Exception{
        for (byte[] data : dataList) {
            Document doc = new Document();
            Map<String, Object> dataMap = JsonUtil.parse(data);
            Object o = dataMap.get("access_time");
            if(o != null){
                doc.add(new StringField("access_time", o.toString(), Field.Store.YES));
            }
            o = dataMap.get("reply_code");
            if(o != null){
                doc.add(new IntPoint("reply_code", Integer.parseInt(o.toString())));
            }
            o = dataMap.get("host_md5");
            if(o != null){
                doc.add(new StringField("host_md5", o.toString(), Field.Store.YES));
            }
            o = dataMap.get("sport");
            if(o != null){
                doc.add(new IntPoint("sport", Integer.parseInt(o.toString())));
            }
            o = dataMap.get("count");
            if(o != null){
                doc.add(new StringField("count", o.toString(), Field.Store.YES));
            }
            o = dataMap.get("sip");
            if(o != null){
                doc.add(new StringField("sip", o.toString(), Field.Store.YES));
            }
            o = dataMap.get("host");
            if(o != null){
                doc.add(new TextField("host", o.toString(), Field.Store.YES));
            }
            o = dataMap.get("host_raw");
            if(o != null){
                doc.add(new StringField("host_raw", o.toString(), Field.Store.YES));
            }
            o = dataMap.get("serial_num");
            if(o != null){
                doc.add(new StringField("serial_num", o.toString(), Field.Store.YES));
            }
            o = dataMap.get("dns_type");
            if(o != null){
                doc.add(new IntPoint("dns_type", Integer.parseInt(o.toString())));
            }
            o = dataMap.get("dport");
            if(o != null){
                doc.add(new IntPoint("dport", Integer.parseInt(o.toString())));
            }
            o = dataMap.get("dip");
            if(o != null){
                doc.add(new StringField("dip", o.toString(), Field.Store.YES));
            }
            indexWriter.addDocument(doc);
        }
        indexWriter.commit();
    }
}
