package edu.isr.versevibe.constants;

public class Constants {
    public static final String INDEX_CREATION_ERROR = "Error while creating index: ";
    public static final String FILE_NOT_FOUND_MSG = "File Not Found Exception Occurred";
    public static final String INDEX_NAME = "verse_vibe_index";
    public static final String HTTP = "http";
    public static final String ATTRIBUTE_MAPPINGS = """
                {
                    "settings": {
                        "number_of_shards": 1,
                        "number_of_replicas": 1,
                        "analysis": {
                            "analyzer": {
                                "song_analyzer": {
                                    "type": "custom",
                                    "tokenizer": "standard",
                                    "filter": [
                                        "lowercase",
                                        "stop",
                                        "asciifolding"
                                    ]
                                }
                            }
                        }
                    },
                    "mappings": {
                        "properties": {
                            "title": {
                                "type": "text",
                                "analyzer": "song_analyzer",
                                "fields": {
                                    "keyword": {
                                        "type": "keyword",
                                        "ignore_above": 256
                                    }
                                }
                            },
                            "tag": {
                                "type": "keyword"
                            },
                            "artist": {
                                "type": "text",
                                "analyzer": "song_analyzer",
                                "fields": {
                                    "keyword": {
                                        "type": "keyword",
                                        "ignore_above": 256
                                    }
                                }
                            },
                            "year": {
                                "type": "keyword"
                            },
                            "features": {
                                "type": "text",
                                "analyzer": "song_analyzer"
                            },
                            "lyrics": {
                                "type": "text",
                                "analyzer": "song_analyzer",
                                "index_options": "offsets"
                            },
                            "id": {
                                "type": "keyword"
                            },
                            "language": {
                                "type": "keyword"
                            },
                            "generatedAt": {
                                "type": "date"
                            }
                        }
                    }
                }
            """;
}
