/**
 * Created by barat on 16-06-2018.
 */
package com.example.barat.chedi;

    import com.google.firebase.database.IgnoreExtraProperties;

    /**
     * Created by Belal on 2/26/2017.
     */
    @IgnoreExtraProperties
    public class Test {
        private String artistId;
        private String artistName;
        private String artistGenre;

        public Test(){
            //this constructor is required
        }

        public Test(String artistId, String artistName, String artistGenre) {
            this.artistId = artistId;
            this.artistName = artistName;
            this.artistGenre = artistGenre;
        }

        public String getTestId() {
            return artistId;
        }

        public String getTestTime() {
            return artistName;
        }

        public String getTestGenre() {
            return artistGenre;
        }
    }

