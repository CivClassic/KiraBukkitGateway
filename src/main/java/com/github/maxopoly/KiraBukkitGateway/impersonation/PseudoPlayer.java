package com.github.maxopoly.KiraBukkitGateway.impersonation;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.OfflinePlayer;
import org.bukkit.Particle;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.Statistic;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.craftbukkit.v1_16_R1.CraftServer;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R1.scoreboard.CraftScoreboard;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Villager;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import com.github.maxopoly.KiraBukkitGateway.KiraBukkitGatewayPlugin;

public class PseudoPlayer extends CraftPlayer {

	private String name;
	private UUID uuid;
	private OfflinePlayer offlinePlayer;
	private List<String> replies;
	private long discordChannelId;
	private PseudoSpigotPlayer spigotPlayer;

	public PseudoPlayer(UUID uuid, long channelId) {
		super((CraftServer) Bukkit.getServer(), PseudoPlayerIdentity.generate(uuid, ""));
		if (uuid == null) {
			throw new IllegalArgumentException("No null uuid allowed");
		}
		offlinePlayer = Bukkit.getOfflinePlayer(uuid);
		if (offlinePlayer == null) {
			throw new IllegalArgumentException("No such player known: " + uuid.toString());
		}
		name = offlinePlayer.getName();
		this.discordChannelId = channelId;
		this.uuid = uuid;
		this.spigotPlayer = new PseudoSpigotPlayer(this);
		replies = new LinkedList<>();
	}

	public synchronized List<String> collectReplies() {
		List<String> replyCopy = replies;
		replies = null;
		return replyCopy;
	}

	public OfflinePlayer getOfflinePlayer() {
		return offlinePlayer;
	}

	@Override
	public void closeInventory() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getCooldown(Material arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Inventory getEnderChest() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getExpToLevel() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public GameMode getGameMode() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public PlayerInventory getInventory() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public ItemStack getItemInHand() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public ItemStack getItemOnCursor() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public MainHand getMainHand() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public InventoryView getOpenInventory() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Entity getShoulderEntityLeft() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Entity getShoulderEntityRight() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getSleepTicks() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean hasCooldown(Material arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isBlocking() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isHandRaised() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isSleeping() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public InventoryView openEnchanting(Location arg0, boolean arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public InventoryView openInventory(Inventory arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void openInventory(InventoryView arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public InventoryView openMerchant(Villager arg0, boolean arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public InventoryView openMerchant(Merchant arg0, boolean arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public InventoryView openWorkbench(Location arg0, boolean arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setCooldown(Material arg0, int arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setGameMode(GameMode arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setItemInHand(ItemStack arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setItemOnCursor(ItemStack arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setShoulderEntityLeft(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setShoulderEntityRight(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean setWindowProperty(Property arg0, int arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean addPotionEffect(PotionEffect arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean addPotionEffect(PotionEffect arg0, boolean arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean getCanPickupItems() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public EntityEquipment getEquipment() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public double getEyeHeight() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public double getEyeHeight(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Location getEyeLocation() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Player getKiller() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public double getLastDamage() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(Set<Material> arg0, int arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Entity getLeashHolder() throws IllegalStateException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public List<Block> getLineOfSight(Set<Material> arg0, int arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getMaximumAir() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getMaximumNoDamageTicks() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getNoDamageTicks() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public PotionEffect getPotionEffect(PotionEffectType arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getRemainingAir() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Block getTargetBlock(Set<Material> arg0, int arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean hasAI() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean hasLineOfSight(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isCollidable() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isGliding() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isLeashed() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void removePotionEffect(PotionEffectType arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setAI(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setCanPickupItems(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setCollidable(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setGliding(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setLastDamage(double arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean setLeashHolder(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setMaximumAir(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setMaximumNoDamageTicks(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setNoDamageTicks(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setRemainingAir(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setRemoveWhenFarAway(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public AttributeInstance getAttribute(Attribute arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean addPassenger(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean addScoreboardTag(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean eject() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getEntityId() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public float getFallDistance() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getFireTicks() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public double getHeight() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public EntityDamageEvent getLastDamageCause() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Location getLocation() {
		return new Location(Bukkit.getWorlds().get(0), 0, -1000, 0);
	}

	@Override
	public Location getLocation(Location arg0) {
		return new Location(Bukkit.getWorlds().get(0), 0, -1000, 0);
	}

	@Override
	public int getMaxFireTicks() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Entity getPassenger() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public List<Entity> getPassengers() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getPortalCooldown() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Set<String> getScoreboardTags() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Server getServer() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getTicksLived() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public EntityType getType() {
		return EntityType.PLAYER;
	}

	@Override
	public UUID getUniqueId() {
		return uuid;
	}

	@Override
	public Entity getVehicle() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Vector getVelocity() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public double getWidth() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public World getWorld() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean hasGravity() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isCustomNameVisible() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isDead() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isEmpty() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isGlowing() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isInsideVehicle() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isInvulnerable() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isOnGround() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isSilent() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isValid() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean leaveVehicle() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void playEffect(EntityEffect arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void remove() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean removePassenger(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean removeScoreboardTag(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setCustomNameVisible(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setFallDistance(float arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setFireTicks(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setGlowing(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setGravity(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setInvulnerable(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setLastDamageCause(EntityDamageEvent arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean setPassenger(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setPortalCooldown(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setSilent(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setTicksLived(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setVelocity(Vector arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean teleport(Location arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean teleport(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean teleport(Location arg0, TeleportCause arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean teleport(Entity arg0, TeleportCause arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public List<MetadataValue> getMetadata(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean hasMetadata(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void removeMetadata(String arg0, Plugin arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setMetadata(String arg0, MetadataValue arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public synchronized void sendMessage(String msg) {
		if (replies == null) {
			KiraBukkitGatewayPlugin.getInstance().getRabbit().replyToUser(uuid, msg, discordChannelId);
		} else {
			replies.add(msg);
		}
	}

	@Override
	public void sendMessage(String[] arg0) {
		StringBuilder sb = new StringBuilder();
		Arrays.stream(arg0).forEach(s -> sb.append(s + '\n'));
		sendMessage(sb.toString());
	}

	@Override
	public PermissionAttachment addAttachment(Plugin arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin arg0, int arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean hasPermission(String arg0) {
		return KiraBukkitGatewayPlugin.getInstance().getPermsWrapper().hasPermission(uuid, arg0);
	}

	@Override
	public boolean hasPermission(Permission arg0) {
		return KiraBukkitGatewayPlugin.getInstance().getPermsWrapper().hasPermission(uuid, arg0.getName());
	}

	@Override
	public boolean isPermissionSet(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isPermissionSet(Permission arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void recalculatePermissions() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void removeAttachment(PermissionAttachment arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isOp() {
		return false;
	}

	@Override
	public void setOp(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public String getCustomName() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setCustomName(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void damage(double arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void damage(double arg0, Entity arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public double getHealth() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public double getMaxHealth() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void resetMaxHealth() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setHealth(double arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setMaxHealth(double arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> arg0, Vector arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void abandonConversation(Conversation arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void abandonConversation(Conversation arg0, ConversationAbandonedEvent arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void acceptConversationInput(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean beginConversation(Conversation arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isConversing() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public long getFirstPlayed() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public long getLastPlayed() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Player getPlayer() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean hasPlayedBefore() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isBanned() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isOnline() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isWhitelisted() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setWhitelisted(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Map<String, Object> serialize() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean canSee(Player arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void chat(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void decrementStatistic(Statistic arg0) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void decrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void decrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void decrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void decrementStatistic(Statistic arg0, EntityType arg1, int arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public InetSocketAddress getAddress() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public AdvancementProgress getAdvancementProgress(Advancement arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean getAllowFlight() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Location getBedSpawnLocation() {
		return offlinePlayer.getBedSpawnLocation();
	}

	@Override
	public Location getCompassTarget() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public float getExhaustion() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public float getExp() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public float getFlySpeed() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getFoodLevel() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public double getHealthScale() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getLevel() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public String getLocale() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public String getPlayerListName() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public long getPlayerTime() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public long getPlayerTimeOffset() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public WeatherType getPlayerWeather() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public float getSaturation() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public CraftScoreboard getScoreboard() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Entity getSpectatorTarget() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getStatistic(Statistic arg0) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public int getTotalExperience() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public float getWalkSpeed() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void giveExp(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void giveExpLevels(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void hidePlayer(Player arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void hidePlayer(Plugin arg0, Player arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void incrementStatistic(Statistic arg0) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void incrementStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void incrementStatistic(Statistic arg0, Material arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void incrementStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void incrementStatistic(Statistic arg0, EntityType arg1, int arg2) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isFlying() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isHealthScaled() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isPlayerTimeRelative() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isSleepingIgnored() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isSneaking() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean isSprinting() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void kickPlayer(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void loadData() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean performCommand(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void playEffect(Location arg0, Effect arg1, int arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T> void playEffect(Location arg0, Effect arg1, T arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void playNote(Location arg0, byte arg1, byte arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void playNote(Location arg0, Instrument arg1, Note arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void playSound(Location arg0, Sound arg1, float arg2, float arg3) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void playSound(Location arg0, String arg1, float arg2, float arg3) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void playSound(Location arg0, Sound arg1, SoundCategory arg2, float arg3, float arg4) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void playSound(Location arg0, String arg1, SoundCategory arg2, float arg3, float arg4) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void resetPlayerTime() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void resetPlayerWeather() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void resetTitle() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void saveData() {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void sendBlockChange(Location arg0, Material arg1, byte arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public boolean sendChunkChange(Location arg0, int arg1, int arg2, int arg3, byte[] arg4) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void sendMap(MapView arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void sendRawMessage(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void sendSignChange(Location arg0, String[] arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void sendTitle(String arg0, String arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void sendTitle(String arg0, String arg1, int arg2, int arg3, int arg4) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setAllowFlight(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setBedSpawnLocation(Location arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setBedSpawnLocation(Location arg0, boolean arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setCompassTarget(Location arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setDisplayName(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setExhaustion(float arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setExp(float arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setFlySpeed(float arg0) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setFlying(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setFoodLevel(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setHealthScale(double arg0) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setHealthScaled(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setLevel(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setPlayerListName(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setPlayerTime(long arg0, boolean arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setPlayerWeather(WeatherType arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setResourcePack(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setResourcePack(String arg0, byte[] arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setSaturation(float arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setScoreboard(Scoreboard arg0) throws IllegalArgumentException, IllegalStateException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setSleepingIgnored(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setSneaking(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setSpectatorTarget(Entity arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setSprinting(boolean arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setStatistic(Statistic arg0, int arg1) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setStatistic(Statistic arg0, Material arg1, int arg2) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setStatistic(Statistic arg0, EntityType arg1, int arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setTexturePack(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setTotalExperience(int arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void setWalkSpeed(float arg0) throws IllegalArgumentException {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void showPlayer(Player arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void showPlayer(Plugin arg0, Player arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void spawnParticle(Particle arg0, Location arg1, int arg2) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T> void spawnParticle(Particle arg0, Location arg1, int arg2, T arg3) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T> void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, T arg5) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void spawnParticle(Particle arg0, Location arg1, int arg2, double arg3, double arg4, double arg5) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T> void spawnParticle(Particle arg0, Location arg1, int arg2, double arg3, double arg4, double arg5,
			T arg6) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void spawnParticle(Particle arg0, Location arg1, int arg2, double arg3, double arg4, double arg5,
			double arg6) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, double arg5, double arg6,
			double arg7) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T> void spawnParticle(Particle arg0, Location arg1, int arg2, double arg3, double arg4, double arg5,
			double arg6, T arg7) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T> void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, double arg5,
			double arg6, double arg7, T arg8) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, double arg5, double arg6,
			double arg7, double arg8) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public <T> void spawnParticle(Particle arg0, double arg1, double arg2, double arg3, int arg4, double arg5,
			double arg6, double arg7, double arg8, T arg9) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public Player.Spigot spigot() {
		return spigotPlayer;
	}

	@Override
	public void stopSound(Sound arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void stopSound(String arg0) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void stopSound(Sound arg0, SoundCategory arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void stopSound(String arg0, SoundCategory arg1) {
		throw new InvalidCommandAttemptException();
	}

	@Override
	public void updateInventory() {
		throw new InvalidCommandAttemptException();
	}

}
