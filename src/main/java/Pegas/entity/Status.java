package Pegas.entity;

public enum Status {
    NEW{
        @Override
        public String toString() {
            return "new task";
        }
    },
    IN_PROGRESS{
        @Override
        public String toString() {
            return "task in progress";
        }
    },
    COMPLETED{
        @Override
        public String toString() {
            return "completed task";
        }
    }
}
