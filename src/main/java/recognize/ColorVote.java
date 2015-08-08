package recognize;

/**
 * Created by KZoneOfX on 2015/8/8.
 * ��ɫͶƱ
 */
public class ColorVote extends Color {
    private int VoteNumber;

    public ColorVote(int red, int green, int blue, int voteNumber) {
        super(red, green, blue);
        VoteNumber = voteNumber;
    }

    public ColorVote(int voteNumber) {
        VoteNumber = voteNumber;
    }

    public ColorVote(String name_ch, int voteNumber) {
        super(name_ch);
        VoteNumber = voteNumber;
    }

    public int getVoteNumber() {
        return VoteNumber;
    }

    public void setVoteNumber(int voteNumber) {
        VoteNumber = voteNumber;
    }

    @Override
    public String toString() {
        return "ColorVote{" +
                "VoteNumber=" + VoteNumber +
                "} " + super.toString();
    }
}
