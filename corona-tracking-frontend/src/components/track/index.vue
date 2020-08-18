<template>
   <div class="px-5">
      <v-card class="mx-auto my-5 elevation-1" outlined max-width="1000">
         <v-row class="px-3" justify="center">
            <v-col class="font-weight-bold" align-self="center">Daily Trends</v-col>
            <v-col>
               <v-btn fab x-small style="float: right;" color="primary" @click="$router.push({ name: 'track.create' })" class="elevation-1">
                  <v-icon>mdi-plus</v-icon>
               </v-btn>
            </v-col>
         </v-row>

         <v-divider></v-divider>
         
         <div v-for="(track, index) in data" :key="index" class="pa-3">
            <v-card :class="getStyle(track.status)" outlined>
               <v-row class="px-5">
                  <v-col class="col-sm-6 col-md-3 col-6">
                     <div class="caption font-weight-medium grey--text">Date</div>
                     <div class="text-subtitle-2">{{ processDate(track.createdAt) }}</div>
                  </v-col>
                  <v-col class="col-sm-6 col-md-3 col-6">
                     <div class="caption font-weight-medium grey--text">Symptomps</div>
                     <div class="text-subtitle-2">{{ track.symptomCount }} Symptomps</div>
                  </v-col>
                  <v-col class="col-sm-6 col-md-3 col-6">
                     <div class="caption font-weight-medium grey--text">Status</div>
                     <div class="text-subtitle-2">{{ track.status }}</div>
                  </v-col>
                  <v-col class="col-sm-6 col-md-3 col-6 align-self-center">
                     <v-btn color="secondary" class="elevation-1 mx-1" 
                           @click="showTrackDetail(track)" fab x-small dark>
                        <v-icon>mdi-television</v-icon>
                     </v-btn>
                     <v-btn color="red" class="elevation-1" fab x-small dark
                           @click="deleteTrack(track, index)">
                        <v-icon>mdi-delete</v-icon>
                     </v-btn>
                  </v-col>
               </v-row>
            </v-card>
         </div>
      </v-card>

      <v-dialog v-model="dialog" max-width="500">
         <TrackDetail
            @closeDialog="dialog = false"
            :detail="selectedTrack"
         ></TrackDetail>
      </v-dialog>

   </div>
</template>

<script>
import TrackDetail from '@/components/track/show'
import Moment from "moment";

export default {
   components: { TrackDetail },
   async created() {
      try {
         this.data = await this.$store.dispatch('retrieveTracks')
      } catch(exception) {
         this.$toaster.e(exception)
      }
   },
   data() {
      return {
         data: [],
         dialog: false,
         selectedTrack: {}
      }
   },
   methods: {
      getStyle(status) {
         if (status == 'High Risk') { return 'border-red' }
         if (status == 'Medium Risk') { return 'border-orange' }
         if (status == 'Low Risk') { return 'border-green' }
      },
      showTrackDetail(track) {
         this.selectedTrack = track
         this.dialog = true
      },
      async deleteTrack(track, index) {
         const payload = { id: track.id }
         try {
            const result = await this.$store.dispatch('deleteTrack', payload)
            if (result.success) {
               this.$toastr.s('Track Deleted Successfully')
               this.data.splice(index, 1)
            } else {
               this.$toastr.e('Track could not be Deleted')
            }
         } 
         catch (exception) {
            console.log(exception)
            this.$toastr.e('Track could not be Deleted')
         }
                    
      },
      processDate(date) {
         return Moment(date).format("YYYY-MM-DD");
      },
   }
};
</script>

<style scoped>
.border-green {
   border: 1px solid rgb(46, 219, 46);
   border-right: 5px solid rgb(46, 219, 46);
   background: rgba(186, 253, 86, 0.137);
}

.border-orange {
   border-right: 5px solid rgb(255, 165, 0);
   border-color: rgb(255, 165, 0);
   background: rgba(247, 173, 36, 0.137);
}

.border-red {
   border-right: 5px solid red;
   border-color: red;
   background: rgba(247, 36, 36, 0.137);
}
</style>