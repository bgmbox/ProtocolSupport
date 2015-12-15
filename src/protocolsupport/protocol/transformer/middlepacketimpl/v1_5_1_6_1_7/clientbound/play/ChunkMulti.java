package protocolsupport.protocol.transformer.middlepacketimpl.v1_5_1_6_1_7.clientbound.play;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.ClientBoundPacket;
import protocolsupport.protocol.PacketDataSerializer;
import protocolsupport.protocol.transformer.middlepacket.clientbound.play.MiddleChunkMulti;
import protocolsupport.protocol.transformer.middlepacketimpl.PacketData;
import protocolsupport.protocol.transformer.utils.ChunkTransformer;
import protocolsupport.utils.CompressionUtils;

public class ChunkMulti extends MiddleChunkMulti<Collection<PacketData>> {

	@Override
	public Collection<PacketData> toData(ProtocolVersion version) throws IOException {
		PacketDataSerializer serializer = PacketDataSerializer.createNew(version);
		ByteArrayOutputStream stream = new ByteArrayOutputStream(23000);
		for (int i = 0; i < data.length; i++) {
			stream.write(ChunkTransformer.toPre18Data(data[i], bitmap[i], version));
		}
		byte[] compressed = CompressionUtils.compress(stream.toByteArray());
		serializer.writeShort(data.length);
		serializer.writeInt(compressed.length);
		serializer.writeBoolean(hasSkyLight);
		serializer.writeBytes(compressed);
		for (int i = 0; i < data.length; i++) {
			serializer.writeInt(chunkX[i]);
			serializer.writeInt(chunkZ[i]);
			serializer.writeShort(bitmap[i]);
			serializer.writeShort(0);
		}
		return Collections.singletonList(new PacketData(ClientBoundPacket.PLAY_CHUNK_MULTI_ID, serializer));
	}

}