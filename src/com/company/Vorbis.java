package com.company;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentFieldKey;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by reinout on 10/25/16.
 */
public class Vorbis implements AudioMetadata {

    VorbisCommentTag tag=null;
    @Override
    public Map<String, String> getMetadata() {
        if (tag != null) {
            Map<String, String> metadata = new HashMap<>();
            metadata.put("Album", tag.getFirst(VorbisCommentFieldKey.ALBUM));
            metadata.put("Artist", tag.getFirst(VorbisCommentFieldKey.ARTIST));
            metadata.put("BPM", tag.getFirst(VorbisCommentFieldKey.BPM));
            metadata.put("Comment", tag.getFirst(VorbisCommentFieldKey.COMMENT));
            metadata.put("Composer", tag.getFirst(VorbisCommentFieldKey.COMPOSER));
            metadata.put("Genre", tag.getFirst(VorbisCommentFieldKey.GENRE));
            metadata.put("Title", tag.getFirst(VorbisCommentFieldKey.TITLE));
            metadata.put("Year", tag.getFirst(VorbisCommentFieldKey.ORIGINAL_YEAR));
        }
        return null;
    }

    @Override
    public boolean setFile(File audioFile) {
        try{
            AudioFile f = AudioFileIO.read(audioFile);
            tag = (VorbisCommentTag)f.getTag();
            AudioHeader header = f.getAudioHeader();
        }catch(Exception e){
           System.out.println("Exception " + e + "found at audio metadata loading");
            return false;
        }
        return true;
    }

    @Override
    public void setMetadata(FieldKey key, String value) {

    }


}